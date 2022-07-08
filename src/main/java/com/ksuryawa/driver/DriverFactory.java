package com.ksuryawa.driver;

import com.ksuryawa.config.factory.ConfigFactory;
import com.ksuryawa.enums.RunMode;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Kapil Suryawanshi
 * 03/07/2022
 */
public final class DriverFactory {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverFactory() {
	}

/**
	 * Gets the browser value and initialise the browser based on that
	 *
	 * @author Kapil Suryawanshi
	 * 03/07/2022
	 * @param browser
	 * @return driver instance of WebDriver
	 * @throws MalformedURLException
	 *
	 */

	public static WebDriver getDriver(String browser) throws MalformedURLException {

		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String runMode = ConfigFactory.getConfig().runMode();

		if (browser.equalsIgnoreCase("chrome"))
		{
			if (runMode.equalsIgnoreCase(String.valueOf(RunMode.REMOTE)))
			{
				capabilities.setBrowserName("chrome");
				driver = new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteUrl()), capabilities);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			if (runMode.equalsIgnoreCase(String.valueOf(RunMode.REMOTE))) {
				capabilities.setBrowserName("firefox");
				driver = new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteUrl()), capabilities);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver =new FirefoxDriver();
			}
		}
		else if (browser.equalsIgnoreCase("safari")) {
			if (runMode.equalsIgnoreCase(String.valueOf(RunMode.REMOTE))) {
				capabilities.setBrowserName("safari");
				driver = new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteUrl()), capabilities);
			} else {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
		}

		return driver;
	}

}