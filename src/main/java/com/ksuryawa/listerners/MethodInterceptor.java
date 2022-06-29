package com.ksuryawa.listerners;

import com.ksuryawa.entities.TestRunManager;
import com.ksuryawa.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kapil Suryawanshi
 * 28/06/2022
 */


public class MethodInterceptor implements IMethodInterceptor{
	/**
	 * Intercepts the existing test methods and changes the annotation value at the run time
	 * Values are fetched from the excel sheet.
	 * User has to choose yes/No in the RunManager sheet.
	 * Suppose if there are 3 tests named a,b,c needs to be run, it reads the excel and understand user wants to
	 * run only a and c, then it will return the same after performing the comparisons.
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

		List<TestRunManager> testDataList = ExcelUtils.getRunnerTestData();
		List<IMethodInstance> result = new ArrayList<>();

		for (IMethodInstance iMethodInstance : list) {
			for (TestRunManager testRunManager : testDataList) {
				if (iMethodInstance.getMethod().getMethodName().equalsIgnoreCase(testRunManager.getTestCaseName()) &&
						Boolean.TRUE.equals(testRunManager.getExecute())) {
					iMethodInstance.getMethod().setDescription(testRunManager.getTestDescription());
					iMethodInstance.getMethod().setInvocationCount(testRunManager.getCount());
					iMethodInstance.getMethod().setPriority(testRunManager.getPriority());
					result.add(iMethodInstance);
				}
			}
		}
		return result;
	}
}