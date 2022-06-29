package com.ksuryawa.utils;

import com.ksuryawa.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Utility to take bas64 screenshot
 *
 * @author Kapil Suryawanshi
 * 23/06/2022
 *
 * @see com.ksuryawa.reports.ExtentLogger
 */
public final class ScreenshotUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ScreenshotUtils(){}

	/**
	 * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
	 * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
	 * a new method.
	 *
	 * @return Image in the form of Base64 String which can be appended directly to report
	 */
	public static String getBase64Image(){
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

	}

}