package io.openems.edge.predictor.lstmmodel;

import io.openems.common.types.OpenemsType;
import io.openems.edge.common.channel.Doc;
import io.openems.edge.common.channel.DoubleReadChannel;
import io.openems.edge.common.channel.StringReadChannel;
import io.openems.edge.common.channel.value.Value;
import io.openems.edge.common.component.OpenemsComponent;

public interface LstmModel extends OpenemsComponent {

	public enum ChannelId implements io.openems.edge.common.channel.ChannelId {
		LAST_TRAINED_TIME(Doc.of(OpenemsType.STRING) //
				.text("Last trained time in Unixstimestamp")), //
		MODEL_ERROR(Doc.of(OpenemsType.DOUBLE) //
				.text("Last trained time in Unixstimestamp"));

		private final Doc doc;

		private ChannelId(Doc doc) {
			this.doc = doc;
		}

		@Override
		public Doc doc() {
			return this.doc;
		}
	}

	/**
	 * Gets the Channel for {@link ChannelId#LAST_TRAINED_TIME}.
	 *
	 * @return the Channel
	 */
	public default StringReadChannel getLastTrainedTimeChannel() {
		return this.channel(ChannelId.LAST_TRAINED_TIME);
	}

	/**
	 * Gets the Last time trained time in Unix time stamp. See
	 * {@link ChannelId#LAST_TRAINED_TIME}.
	 *
	 * @return the Channel {@link Value}
	 */
	public default Value<String> getLastTrainedTime() {
		return this.getLastTrainedTimeChannel().value();
	}

	/**
	 * Internal method to set the 'nextValue' on {@link ChannelId#LAST_TRAINED_TIME}
	 * Channel.
	 *
	 * @param value the next value
	 */
	public default void _setLastTrainedTime(String value) {
		this.getLastTrainedTimeChannel().setNextValue(value);
	}

	/**
	 * Gets the Channel for {@link ChannelId#MODEL_ERROR}.
	 *
	 * @return the Channel
	 */
	public default DoubleReadChannel getModelErrorChannel() {
		return this.channel(ChannelId.MODEL_ERROR);
	}

	/**
	 * Gets the Model error. See {@link ChannelId#MODEL_ERROR}.
	 *
	 * @return the Channel {@link Value}
	 */
	public default Value<Double> getModelError() {
		return this.getModelErrorChannel().value();
	}

	/**
	 * Internal method to set the 'nextValue' on {@link ChannelId#LAST_TRAINED_TIME}
	 * Channel.
	 *
	 * @param value the next value
	 */
	public default void _setModelError(Double value) {
		this.getModelErrorChannel().setNextValue(value);
	}

}
