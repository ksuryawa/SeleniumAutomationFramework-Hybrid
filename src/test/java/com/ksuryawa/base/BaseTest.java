package com.ksuryawa.base;

import com.ksuryawa.config.factory.ConfigFactory;
import com.ksuryawa.driver.Driver;
import com.ksuryawa.entities.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

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
	protected void setUp(Object[] data) {
		TestData testData = (TestData) data[0];

		Driver.initDriver(Objects.isNull(testData.getBrowser()) ? ConfigFactory.getConfig().browser() : testData.getBrowser());

	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}