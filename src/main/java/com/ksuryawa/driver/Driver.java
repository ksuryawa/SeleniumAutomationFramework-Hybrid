package com.ksuryawa.driver;

import com.ksuryawa.factories.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

/**
 * Driver class is responsible for invoking and closing the browsers.
 *
 * It is also responsible for
 * setting the driver variable to DriverManager which handles the thread safety for the
 * webdriver instance.
 *
 * @author Kapil Suryawanshi
 *
 * @see DriverManager
 * @see com.ksuryawa.tests
 */
public class Driver {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private Driver() {
	}

	/**
	 * Gets the browser value and initialise the browser based on that
	 *
	 * @author Kapil Suryawanshi
	 */
	public static void initDriver() {
		if (Objects.isNull(DriverManager.getDriver())) {

			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver());

			DriverManager.getDriver().get(ConfigFactory.getConfig().url());
		}
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 *
	 * @author Kapil Suryawanshi
	 */
	public static void quitDriver() {
		if (!Objects.isNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}

}