package io.openems.edge.simulator.meter.production.acting;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import io.openems.common.types.MeterType;

@ObjectClassDefinition(//
		name = "Simulator ProductionMeter Acting", //
		description = "This simulates an 'acting' Production meter using data provided by a data source.")
@interface Config {

	@AttributeDefinition(name = "Component-ID", description = "Unique ID of this Component")
	String id() default "meter1";

	@AttributeDefinition(name = "Alias", description = "Human-readable name of this Component; defaults to Component-ID")
	String alias() default "";
	
	@AttributeDefinition(name = "Meter-Type", description = "What is measured by this Meter?")
	MeterType type() default MeterType.PRODUCTION;

	@AttributeDefinition(name = "Is enabled?", description = "Is this Component enabled?")
	boolean enabled() default true;

	@AttributeDefinition(name = "Datasource-ID", description = "ID of Simulator Datasource.")
	String datasource_id() default "datasource0";

	@AttributeDefinition(name = "Datasource target filter", description = "This is auto-generated by 'Datasource-ID'.")
	String datasource_target() default "(enabled=true)";

	String webconsole_configurationFactory_nameHint() default "Simulator ProductionMeter Acting [{id}]";
}