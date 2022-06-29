package com.ksuryawa.utils;


import com.creditdatamw.zerocell.Reader;
import com.ksuryawa.constants.FrameworkConstants;
import com.ksuryawa.entities.TestData;
import com.ksuryawa.entities.TestRunManager;

import java.io.File;
import java.util.List;

/**
 * @author Kapil Suryawanshi
 * 28/06/2022
 */
public final class ExcelUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExcelUtils() {
	}


	public static List<TestRunManager> getRunnerTestData()
	{
		return Reader.of(TestRunManager.class)
				.from(new File(FrameworkConstants.getTestDataExcelPath()))
				.sheet(FrameworkConstants.getRunmangerDatasheet())
				.list();

	}

	public static List<TestData> getTestData()
	{
		return Reader.of(TestData.class)
				.from(new File(FrameworkConstants.getTestDataExcelPath()))
				.sheet(FrameworkConstants.getIterationDatasheet())
				.list();

	}

	public static List<Object> getTestData(String sheetName, Class<?> clazz)
	{
		return Reader.of(clazz)
				.from(new File(FrameworkConstants.getTestDataExcelPath()))
				.sheet(sheetName)
				.list();

	}


}