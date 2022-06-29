package com.ksuryawa.converters.owner;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

/**
 * @author Kapil Suryawanshi
 * 29/06/2022
 */
public class StringToBooleanConverter implements Converter<Boolean> {
	@Override
	public Boolean convert(Method method, String stringBoolean) {
		return stringBoolean.equalsIgnoreCase("yes");
	}
}