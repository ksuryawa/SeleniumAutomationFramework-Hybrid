package com.ksuryawa.listerners;


import com.ksuryawa.config.factory.ConfigFactory;
import com.ksuryawa.constants.FrameworkConstants;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Kapil Suryawanshi
 * 29/06/2022
 */
public class RetryFailedTests implements IRetryAnalyzer {
	private int retryCount = 0;

	@Override
	public boolean retry(ITestResult iTestResult) {
		boolean retry = false;
		if (Boolean.TRUE.equals(ConfigFactory.getConfig().retryfailedtests()))
		{
			retry = retryCount < FrameworkConstants.getMaxRetryCount();

			retryCount++;
		}
		return retry;
	}
}