package com.ksuryawa.listerners;

import com.ksuryawa.annotations.FrameworkAnnotations;
import com.ksuryawa.reports.ExtentLogger;
import com.ksuryawa.reports.ExtentReport;
import com.ksuryawa.utils.ELKUtils;
import org.testng.*;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 *  Mostly used to help in extent report generation
 *
 *  <pre>Please make sure to add the listener details in the testng.xml file</pre>
 *  <p>
 * @author Kapil Suryawanshi
 * 22/06/2022
 */
public class TestListeners implements ITestListener, ISuiteListener {
	/**
	 *Initialise the reports with the file name
	 * @see com.ksuryawa.reports.ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	/**
	 * Terminate the  extent reports
	 * @see com.ksuryawa.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

	/**
	 * Starts a test node for each testng test
	 * @see com.ksuryawa.reports.ExtentReport
	 */
	@Override
	public void onTestStart(ITestResult result) {
		String description = result.getMethod().getDescription();

		if (description.isEmpty() || description.isBlank()) {
			ExtentReport.createTest(result.getName());
		}
		else {
			ExtentReport.createTest(description);
		}

		FrameworkAnnotations annotations = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class);

		ExtentReport.addAuthor(annotations.author());
		ExtentReport.addCategory(annotations.category());
	}

	/**
	 * Marks the test as pass and logs it in the report
	 *
	 * @see com.ksuryawa.reports.ExtentLogger
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getDescription() + " is passed",true);
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(),"Pass");
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 *
	 * @see com.ksuryawa.reports.ExtentLogger
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getDescription() + " is failed",true);
		ExtentLogger.info(result.getThrowable().toString());
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(),"Fail");
	}

	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.ksuryawa.reports
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getDescription() + " is skipped");
		ELKUtils.sendDetailsToElk(result.getMethod().getDescription(),"Skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * For now, we are not using this.
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we don't have any special implementation as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we don't have any special implementation as of now
		 */
	}
}