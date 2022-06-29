package com.ksuryawa.base;

import com.ksuryawa.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author Kapil Suryawanshi
 * 19/06/2022
 */
public class BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	protected BaseTest() {
	}

	@BeforeMethod
	protected void setUp() {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}