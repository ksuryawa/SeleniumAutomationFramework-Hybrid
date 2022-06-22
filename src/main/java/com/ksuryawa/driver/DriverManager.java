package com.ksuryawa.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

/**
 * @author Kapil Suryawanshi
 * 19/06/2022
 */
public final class DriverManager {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {
	}

	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 *
	 * @return {@link org.openqa.selenium.WebDriver} instance.
	 * @author Kapil Suryawanshi
	 * 19/06/2022
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * Set the WebDriver instance to thread local variable
	 *
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p>
	 * @author Kapil Suryawanshi
	 * 19/06/2022
	 */
	static void setDriver(WebDriver driverref) {
		if (Objects.nonNull(driverref)) {
			driver.set(driverref);
		}
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 *
	 * @author Kapil Suryawanshi
	 * 19/06/2022
	 */
	static void unload() {
		driver.remove();
	}
}