package com.ksuryawa.constants;

import com.ksuryawa.config.IFrameworkConfig;
import com.ksuryawa.factories.ConfigFactory;

/**
 * Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files
 *
 * @author Kapil Suryawanshi
 *
 *  Jan 21, 2021
 *
 * @see IFrameworkConfig
 * @see ConfigFactory
 */
public final class FrameworkConstants {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstants() {
	}


	private static final int EXPLICIT_WAIT = 10;
	private static final String EXTENT_REPORT_FOLDER_PATH=System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath = "";


	public static Integer getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	public static String getExtentReportFilePath()  {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath()
	{
		return EXTENT_REPORT_FOLDER_PATH+"/index.html";
	}

}