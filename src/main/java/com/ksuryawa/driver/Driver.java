package com.ksuryawa.driver;

import com.ksuryawa.config.factory.ConfigFactory;
import com.ksuryawa.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

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
	public static void initDriver(BrowserType browser) {
		if (Objects.isNull(DriverManager.getDriver()))
		{
			if(browser.equals(BrowserType.CHROME))
			{
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			} else if (browser.equals(BrowserType.FIREFOX)) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}else if (browser.equals(BrowserType.SAFARI)) {
				WebDriverManager.safaridriver().setup();
				DriverManager.setDriver(new SafariDriver());
			}
			DriverManager.getDriver().get(ConfigFactory.getConfig().url());
			DriverManager.getDriver().manage().window().maximize();
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