package io.openems.edge.energy.v1;

import static io.openems.common.utils.DateUtils.roundDownToQuarter;
import static io.openems.common.utils.ReflectionUtils.getValueViaReflection;
import static io.openems.common.utils.ReflectionUtils.invokeMethodWithoutArgumentsViaReflection;
import static io.openems.edge.energy.optimizer.TestData.CONSUMPTION_PREDICTION_QUARTERLY;
import static io.openems.edge.energy.optimizer.TestData.HOURLY_PRICES_SUMMER;
import static io.openems.edge.energy.optimizer.TestData.PRODUCTION_PREDICTION_QUARTERLY;
import static io.openems.edge.energy.v1.optimizer.UtilsV1.SUM_CONSUMPTION;
import static io.openems.edge.energy.v1.optimizer.UtilsV1.SUM_PRODUCTION;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

import io.openems.common.test.TimeLeapClock;
import io.openems.common.utils.ReflectionUtils;
import io.openems.common.utils.ReflectionUtils.ReflectionException;
import io.openems.edge.common.sum.DummySum;
import io.openems.edge.common.test.AbstractComponentTest.TestCase;
import io.openems.edge.common.test.ComponentTest;
import io.openems.edge.common.test.DummyComponentManager;
import io.openems.edge.common.test.DummyConfigurationAdmin;
import io.openems.edge.controller.ess.timeofusetariff.TimeOfUseTariffControllerImpl;
import io.openems.edge.energy.EnergySchedulerImpl;
import io.openems.edge.energy.LogVerbosity;
import io.openems.edge.energy.MyConfig;
import io.openems.edge.energy.api.Version;
import io.openems.edge.energy.v1.optimizer.GlobalContextV1;
import io.openems.edge.energy.v1.optimizer.OptimizerV1;
import io.openems.edge.predictor.api.prediction.Prediction;
import io.openems.edge.predictor.api.test.DummyPredictor;
import io.openems.edge.predictor.api.test.DummyPredictorManager;
import io.openems.edge.timedata.test.DummyTimedata;
import io.openems.edge.timeofusetariff.test.DummyTimeOfUseTariffProvider;

@SuppressWarnings("deprecation")
public class EnergySchedulerImplTest {

	public static final Clock CLOCK = new TimeLeapClock(Instant.parse("2020-03-04T14:19:00.00Z"), ZoneOffset.UTC);

	@Test
	public void test() throws Exception {
		create(CLOCK);
	}

	/**
	 * Creates a {@link EnergySchedulerImplTest} instance.
	 * 
	 * @param clock a {@link Clock}
	 * @return the object
	 * @throws Exception on error
	 */
	public static EnergySchedulerImpl create(Clock clock) throws Exception {
		var now = roundDownToQuarter(ZonedDateTime.now(clock));
		final var midnight = now.truncatedTo(DAYS);
		var componentManager = new DummyComponentManager(clock);
		var sum = new DummySum();
		var predictor0 = new DummyPredictor("predictor0", componentManager,
				Prediction.from(sum, SUM_PRODUCTION, midnight, PRODUCTION_PREDICTION_QUARTERLY), SUM_PRODUCTION);
		var predictor1 = new DummyPredictor("predictor0", componentManager,
				Prediction.from(sum, SUM_CONSUMPTION, midnight, CONSUMPTION_PREDICTION_QUARTERLY), SUM_CONSUMPTION);
		var timeOfUseTariff = DummyTimeOfUseTariffProvider.fromHourlyPrices(clock, HOURLY_PRICES_SUMMER);
		var ctrl = new TimeOfUseTariffControllerImpl(); // this is not fully activated; config is null

		var sut = new EnergySchedulerImpl();
		new ComponentTest(sut) //
				.addReference("cm", new DummyConfigurationAdmin()) //
				.addReference("componentManager", componentManager) //
				.addReference("predictorManager", new DummyPredictorManager(predictor0, predictor1)) //
				.addReference("timedata", new DummyTimedata("timedata0")) //
				.addReference("timeOfUseTariff", timeOfUseTariff) //
				.addReference("schedulables", List.of(ctrl)) //
				.addReference("sum", sum) //
				.activate(MyConfig.create() //
						.setId("ctrl0") //
						.setEnabled(false) //
						.setLogVerbosity(LogVerbosity.DEBUG_LOG) //
						.setVersion(Version.V1_ESS_ONLY) //
						.build()) //
				.next(new TestCase());
		return sut;
	}

	/**
	 * Gets the {@link OptimizerV1} via Java Reflection.
	 * 
	 * @param energyScheduler the {@link EnergySchedulerImpl}
	 * @return the object
	 * @throws ReflectionException on error
	 */
	public static OptimizerV1 getOptimizer(EnergySchedulerImpl energyScheduler) throws ReflectionException {
		return getValueViaReflection(energyScheduler, "optimizerV1");
	}

	/**
	 * Calls the 'createParams()' method in the {@link OptimizerV1} via Java
	 * Reflection.
	 * 
	 * @param optimizer the {@link OptimizerV1}
	 * @throws Exception on error
	 */
	public static void callCreateParams(OptimizerV1 optimizer) throws Exception {
		invokeMethodWithoutArgumentsViaReflection(optimizer, "createParams");
	}

	/**
	 * Gets the {@link GlobalContextV1} via Java Reflection.
	 * 
	 * @param energyScheduler the {@link EnergySchedulerImpl}
	 * @return the object
	 * @throws Exception on error
	 */
	public static GlobalContextV1 getGlobalContext(EnergySchedulerImpl energyScheduler) throws Exception {
		var optimizer = getOptimizer(energyScheduler);
		return ReflectionUtils.<Supplier<GlobalContextV1>>getValueViaReflection(optimizer, "globalContext").get();
	}
}
