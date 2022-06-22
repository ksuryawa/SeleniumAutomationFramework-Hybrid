package com.ksuryawa.factories;

import com.ksuryawa.config.IFrameworkConfig;
import org.aeonbits.owner.ConfigCache;

/**
 * Factory class to create Config cache
 */
public final class ConfigFactory {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ConfigFactory() {
	}

	/**
	 * Method to create Config cache
	 *
	 * @return IFrameworkConfig
	 */
	public static IFrameworkConfig getConfig() {
		return ConfigCache.getOrCreate(IFrameworkConfig.class);
	}
}