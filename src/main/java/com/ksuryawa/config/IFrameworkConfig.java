package com.ksuryawa.config;


import com.ksuryawa.converters.owner.StringToBooleanConverter;
import com.ksuryawa.converters.owner.StringToBrowserTypeConverter;
import com.ksuryawa.enums.BrowserType;
import org.aeonbits.owner.Config;

/**
 * Read the data from property file using Owner library
 *
 * @see Config
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"system:env",
		"file:${user.dir}/src/test/resources/config/config.properties"
})
public interface IFrameworkConfig extends Config {


	String url();

	@DefaultValue("CHROME")
	@ConverterClass(StringToBrowserTypeConverter.class)
	BrowserType browser();

	@Key("overridereports")
	@ConverterClass(StringToBooleanConverter.class)
	Boolean overrideReports();

	@Key("passedstepsscreenshots")
	@ConverterClass(StringToBooleanConverter.class)
	Boolean passedStepsScreenshots();

	@DefaultValue("no")
	@ConverterClass(StringToBooleanConverter.class)
	Boolean retryfailedtests();

}