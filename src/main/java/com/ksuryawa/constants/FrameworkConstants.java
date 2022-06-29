package com.ksuryawa.constants;

import com.ksuryawa.config.IFrameworkConfig;
import com.ksuryawa.config.factory.ConfigFactory;

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

	private static final String RESOURCES_PATH = System.getProperty("user.dir")+"/src/test/resources";

	private static final String TEST_DATA_EXCEL_PATH = RESOURCES_PATH+"/testdata.xlsx";

	private static final String RUNMANGER_SHEET = "RUNMANAGER";
	private static final String ITERATION_DATA_SHEET = "DATA";

	private static final Integer MAX_RETRY_COUNT = 1;

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
		if(Boolean.FALSE.equals(ConfigFactory.getConfig().overrideReports()))
		{
			return EXTENT_REPORT_FOLDER_PATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENT_REPORT_FOLDER_PATH+"/index.html";
		}
	}

	public static String getTestDataExcelPath() {
		return TEST_DATA_EXCEL_PATH;
	}

	public static String getRunmangerDatasheet() {
		return RUNMANGER_SHEET;
	}

	public static String getIterationDatasheet() {
		return ITERATION_DATA_SHEET;
	}

	public static Integer getMaxRetryCount() {
		return MAX_RETRY_COUNT;
	}
}