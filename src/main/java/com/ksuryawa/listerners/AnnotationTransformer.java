package com.ksuryawa.listerners;

import com.ksuryawa.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *Implements {@link org.testng.IAnnotationTransformer} to leverage certain functionality like updating the annotations of test
 * methods at runtime.
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 *
 *  @author Kapil Suryawanshi
 * 29/06/2022
 */
public class AnnotationTransformer implements IAnnotationTransformer {

	/**
	 * Helps in setting the dataprovider, dataprovider class and retry analyser annotation to all the test methods
	 * at run time.
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getTestData");
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}


}