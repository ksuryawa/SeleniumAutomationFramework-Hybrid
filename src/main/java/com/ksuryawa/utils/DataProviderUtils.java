package com.ksuryawa.utils;

import com.ksuryawa.entities.TestData;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * @author Kapil Suryawanshi
 * 27/06/2022
 */
public final class DataProviderUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DataProviderUtils(){}

	@DataProvider(parallel = true)
	public static Object[] getTestData(Method method)
	{
		return ExcelUtils.getTestData()
				.stream()
				.filter(testData -> testData.getTestCaseName().equalsIgnoreCase(method.getName()))
				.filter(TestData::getExecute)
				.toArray()
				;
		
		
	}

}