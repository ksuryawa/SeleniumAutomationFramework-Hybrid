package com.ksuryawa.listerners;

import com.ksuryawa.reports.ExtentLogger;
import com.ksuryawa.reports.ExtentReport;
import org.testng.*;
import org.testng.annotations.Test;

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
		String description = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();

		if (description.isEmpty() || description.isBlank()) {
			ExtentReport.createTest(result.getName());

		} else {
			ExtentReport.createTest(description);
		}
	}

	/**
	 * Marks the test as pass and logs it in the report
	 *
	 * @see com.ksuryawa.reports.ExtentLogger
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + " is passed",true);
	}

	/**
	 * Marks the test as fail,append base64 screenshot and logs it in the report
	 *
	 * @see com.ksuryawa.reports.ExtentLogger
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getName() + " is failed",true);
		ExtentLogger.info(result.getThrowable().toString());
	}

	/**
	 * Marks the test as skip and logs it in the report
	 * @see com.ksuryawa.reports
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getName() + " is skipped");
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