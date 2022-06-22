package com.ksuryawa.config;

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
}