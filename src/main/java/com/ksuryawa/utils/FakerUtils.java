package com.ksuryawa.utils;

import com.github.javafaker.Faker;

/**
 * Utility to fake data using {@link com.github.javafaker.Faker}
 * Jun 18, 2022
 *
 * @author Kapil Suryawanshi
 * @version 1.0
 * @since 1.0
 */
public final class FakerUtils {

	private static final Faker faker = new Faker();

	/**
	 * Private constructor to avoid external instantiation
	 */
	private FakerUtils() {
	}

	/**
	 * Get random number between given range
	 *
	 * @param startValue - Start index
	 * @param endValue   - Last index
	 * @return Random interger between startValue and endValue
	 */
	static int getNumber(int startValue, int endValue) {
		return faker.number().numberBetween(startValue, endValue);
	}

	/**
	 * Get random first name
	 *
	 * @return firstName
	 */
	static String getFirstName() {
		return faker.name().firstName();
	}

	/**
	 * Get random last name
	 *
	 * @return lastname
	 */
	static String getLastName() {
		return faker.name().lastName();
	}

	/**
	 * Get random email address
	 *
	 * @return email id
	 */
	static String getEmail() {
		return faker.internet().emailAddress();
	}

}