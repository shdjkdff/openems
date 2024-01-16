package io.openems.edge.battery.fenecon.f2b.cluster.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.openems.common.channel.AccessMode;
import io.openems.common.exceptions.OpenemsError.OpenemsNamedException;
import io.openems.common.exceptions.OpenemsException;
import io.openems.edge.battery.api.Battery;
import io.openems.edge.battery.fenecon.f2b.BatteryFeneconF2b;
import io.openems.edge.battery.fenecon.f2b.cluster.parallel.BatteryFeneconF2bClusterParallel;
import io.openems.edge.battery.fenecon.f2b.cluster.serial.BatteryFeneconF2bClusterSerial;
import io.openems.edge.common.component.AbstractOpenemsComponent;
import io.openems.edge.common.component.ComponentManager;
import io.openems.edge.common.component.OpenemsComponent;
import io.openems.edge.common.event.EdgeEventConstants;
import io.openems.edge.common.modbusslave.ModbusSlave;
import io.openems.edge.common.modbusslave.ModbusSlaveNatureTable;
import io.openems.edge.common.modbusslave.ModbusSlaveTable;
import io.openems.edge.common.startstop.StartStop;
import io.openems.edge.common.startstop.StartStopConfig;
import io.openems.edge.common.startstop.StartStoppable;

public abstract class AbstractBatteryFeneconF2bCluster extends AbstractOpenemsComponent implements BatteryFeneconF2b,
		OpenemsComponent, BatteryFeneconF2bCluster, EventHandler, StartStoppable, ModbusSlave {

	protected final AtomicReference<StartStop> startStopTarget = new AtomicReference<>(StartStop.UNDEFINED);
	// TODO should be sorted by Component-ID
	protected final List<BatteryFeneconF2b> batteries = new ArrayList<>();

	private final Logger log = LoggerFactory.getLogger(AbstractBatteryFeneconF2bCluster.class);

	private StartStopConfig startStopConfig;

	protected synchronized void addBattery(BatteryFeneconF2b battery) {
		this.batteries.add(battery);
		this.getChannelManager().deactivate();
		this.getChannelManager().activate(this.batteries, this.getBatteryFeneconF2bCluster());
	}

	protected synchronized void removeBattery(BatteryFeneconF2b battery) {
		this.batteries.remove(battery);
		this.getChannelManager().deactivate();
		this.getChannelManager().activate(this.batteries, this.getBatteryFeneconF2bCluster());
	}

	protected abstract ChannelManager getChannelManager();

	protected abstract ComponentManager getComponentManager();

	protected AbstractBatteryFeneconF2bCluster(io.openems.edge.common.channel.ChannelId[] firstInitialChannelIds,
			io.openems.edge.common.channel.ChannelId[]... furtherInitialChannelIds) {
		super(firstInitialChannelIds, furtherInitialChannelIds);
	}

	@Override
	protected void activate(ComponentContext context, String id, String alias, boolean enabled) {
		throw new IllegalArgumentException("Use the other activate() method!");
	}

	protected void activate(ComponentContext context, String id, String alias, boolean enabled, ConfigurationAdmin cm,
			StartStopConfig startStop) {
		super.activate(context, id, alias, enabled);
		this.startStopConfig = startStop;
	}

	@Override
	protected void deactivate() {
		super.deactivate();
	}

	@Override
	public void handleEvent(Event event) {
		if (!this.isEnabled()) {
			return;
		}
		switch (event.getTopic()) {
		case EdgeEventConstants.TOPIC_CYCLE_BEFORE_PROCESS_IMAGE:
			this.handleStateMachine();
			break;
		}
	}

	@Override
	public ModbusSlaveTable getModbusSlaveTable(AccessMode accessMode) {
		return new ModbusSlaveTable(//
				OpenemsComponent.getModbusSlaveNatureTable(accessMode), //
				Battery.getModbusSlaveNatureTable(accessMode), //
				ModbusSlaveNatureTable.of(BatteryFeneconF2bCluster.class, accessMode, 100) //
						.build());
	}

	@Override
	public synchronized boolean areAllBatteriesStopped() {
		return this.batteries.stream()//
				.allMatch(Battery::isStopped);
	}

	@Override
	public synchronized boolean areAllBatteriesStarted() {
		return this.batteries.stream()//
				.allMatch(Battery::isStarted);
	}

	@Override
	public synchronized void startBatteries() throws OpenemsException {
		if (this.batteries.isEmpty()) {
			this.logInfo(this.log, "Battery list is empty, not found any battery to start");
			return;
		}
		var notStartedBatteries = this.getNotStartedBatteries();
		// Start one battery at a time
		notStartedBatteries.forEach(notStartedBattery -> {
			try {
				notStartedBattery.setHvContactorUnlocked(false);
				notStartedBattery.start();
			} catch (OpenemsNamedException e) {
				this.logError(this.log, "Battery: " + notStartedBattery.id() + " can not start " + e.getMessage());
			}
		});
	}

	@Override
	public synchronized boolean isOneBatteryStartedAndOneStopped() {
		return this.batteries.stream()//
				.anyMatch(Battery::isStarted)
				&& this.batteries.stream()//
						.anyMatch(Battery::isStopped);
	}

	@Override
	public void stopBatteries() {
		if (this.batteries.isEmpty()) {
			this.logInfo(this.log, "Battery list is empty, not found any battery to stop");
			return;
		}

		var notStoppedBatteries = this.getNotStoppedBatteries();
		notStoppedBatteries.forEach(notStoppedBattery -> {
			try {
				notStoppedBattery.stop();
			} catch (OpenemsNamedException e) {
				this.logError(this.log,
						"Battery : " + notStoppedBattery.id() + " battery can not stop" + e.getMessage());
			}
		});
	}

	@Override
	public List<BatteryFeneconF2b> getNotStartedBatteries() {
		return this.getMatchedBatteries(t -> !t.isStarted());
	}

	@Override
	public List<BatteryFeneconF2b> getNotStoppedBatteries() {
		return this.getMatchedBatteries(t -> !t.isStopped());
	}

	/**
	 * This method returns a list of batteries where batteries matched with required
	 * conditions.
	 * 
	 * @param method asked battery condition,e.g. {@link #isStarted()}
	 * @return List of {@link Battery}.
	 */
	private List<BatteryFeneconF2b> getMatchedBatteries(Predicate<BatteryFeneconF2b> method) {
		if (this.batteries.isEmpty()) {
			return null;
		}
		return this.batteries.stream()//
				.filter(method)//
				.toList();
	}

	@Override
	public boolean getAndUpdateHasAnyBatteryFault() {
		final var fault = this.batteries.stream().anyMatch(Battery::hasFaults);
		this._setAtLeastOneBatteryInError(fault);
		return fault;
	}

	@Override
	public boolean getAndUpdateHasAllBatteriesFault() {
		final var fault = this.batteries.stream().allMatch(Battery::hasFaults);
		this._setAllBatteriesAreInFault(fault);
		return fault;
	}

	/**
	 * Handles the State-Machine.
	 */
	protected abstract void handleStateMachine();

	@Override
	public StartStop getStartStopTarget() {
		return switch (this.startStopConfig) {
		case AUTO -> this.startStopTarget.get();
		case START -> StartStop.START;
		case STOP -> StartStop.STOP;
		};
	}

	@Override
	public boolean isSerialCluster() {
		return this.getBatteryFeneconF2bCluster() instanceof BatteryFeneconF2bClusterSerial;
	}

	@Override
	public boolean isParallelCluster() {
		return this.getBatteryFeneconF2bCluster() instanceof BatteryFeneconF2bClusterParallel;
	}
}
