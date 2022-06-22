package com.ksuryawa.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

/**
 * ExtentManager class helps us to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance by Thread local.
 * @author Kapil Suryawanshi
 * 22/06/2022
 */
public final class ExtentManager {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager(){}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;

	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author Kapil Suryawanshi
	 * Jun 21, 2022
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	static ExtentTest getExtentTest() {
		return extTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 *
	 * @author Kapil Suryawanshi
	 * Jun 21, 2022
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 */
	static void setExtentTest(ExtentTest test) {
		if(Objects.nonNull(test)) {
			extTest.set(test);
		}
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 *@author Kapil Suryawanshi
	  * Jun 21, 2022
	 */
	static void unload() {
		extTest.remove();
	}
}