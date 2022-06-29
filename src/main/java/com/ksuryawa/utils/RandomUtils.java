package com.ksuryawa.utils;

/**
 * Utility to use randomize data
 * Jun 18, 2022
 *
 * @author Kapil Suryawanshi
 * @version 1.0
 * @since 1.0
 */
public final class RandomUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private RandomUtils() {
	}

	public static int getId() {
		return FakerUtils.getNumber(100, 10000);
	}

	public static String getFirstName() {
		return FakerUtils.getFirstName();
	}

	public static String getLastName() {
		return FakerUtils.getLastName();
	}

	public static String getEmail() {
		return FakerUtils.getEmail();
	}

}