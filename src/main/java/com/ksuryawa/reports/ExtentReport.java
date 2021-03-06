package com.ksuryawa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ksuryawa.constants.FrameworkConstants;
import com.ksuryawa.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal
 * variable for providing thread safety.
 *
 * @author Kapil Suryawanshi
 * 22/06/2022
 *
 * @see com.ksuryawa.listeners.TestListener
 * @see com.ksuryawa.annotations.FrameworkAnnotation
 */
public final class ExtentReport {

/**
 * Private constructor to avoid external instantiation
 */
private ExtentReport(){}

	private static ExtentReports extent;

	/**
	 * Set the initial configuration for the Extent Reports and decides the report generation path.
	 * @author Kapil Suryawanshi
	 * 22/06/2022
	 */
	public static void initReports(){
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark =new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Orange HRM Test Report");
			spark.config().setReportName("Selenium Web Framework");
		}
	}

	/**
	 * Flushing the reports ensures extent logs are reflected properly.
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 * @author Kapil Suryawanshi
	 * 22/06/2022
	 */
	public static void flushReports() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
	 * @author Kapil Suryawanshi
	  * 22/06/2022
	 * @param testCaseName Test Name that needs to be reflected in the report
	 */
	public static void createTest(String testCaseName){
		ExtentManager.setExtentTest(extent.createTest(testCaseName));
	}


	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives an clear idea of Authors Vs Percentage success metrics
	 *
	 * @param authors Authors who created a particular test case
	 * @author Kapil Suryawanshi
	 * Jun 18, 2022
	 */
	public static void addAuthor(String[] authors) {
		for (String author : authors) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}
	}

	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group Vs Percentage success metrics.
	 *
	 * @param categories category a particular test case belongs to.
	 * @author Kapil Suryawanshi
	 * Jun 18, 2022
	 */
	public static void addCategory(CategoryType[] categories) {
		for (CategoryType category : categories) {
			ExtentManager.getExtentTest().assignCategory(category.toString());
		}
	}
}