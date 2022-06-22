package com.ksuryawa.reports;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * xtent logger class helps to log test case result in extent report
 *
 * @author Kapil Suryawanshi
 * 22/06/2022
 */
public final class ExtentLogger {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentLogger(){}

	/**
	 *
	 * @param message Message to write in Extent report
	 */
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message)
	{
		ExtentManager.getExtentTest().info(message);
	}

}