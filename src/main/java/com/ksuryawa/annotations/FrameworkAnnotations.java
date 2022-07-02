package com.ksuryawa.annotations;

import com.ksuryawa.enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and
 * category details to the extent report.
 * <p>
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * <p>
 * Jun 28, 2022
 *
 * @author Kapil Suryawanshi
 * @version 1.0
 * @see com.ksuryawa.tests
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {

	/**
	 * Store the authors who created the tests in String[]
	 * Default value - Kapil
	 *
	 * @return author
	 * @author Kapil Suryawanshi
	 * Jun 18, 2022
	 */
	String[] author() default "Kapil";

	/**
	 * Stores the category in form of Enum Array. Include the possible values in {@link com.ksuryawa.enums.CategoryType}
	 *
	 * @return category
	 * Jun 18, 2022
	 * @author Kapil Suryawanshi
	 */
	CategoryType[] category() default CategoryType.REGRESSION;


}