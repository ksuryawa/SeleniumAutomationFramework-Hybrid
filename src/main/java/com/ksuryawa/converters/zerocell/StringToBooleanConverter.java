package com.ksuryawa.converters.zerocell;


import com.creditdatamw.zerocell.converter.Converter;


/**
 * @author Kapil Suryawanshi
 * 28/06/2022
 */
public class StringToBooleanConverter implements Converter<Boolean> {

	@Override
	public Boolean convert(String value, String s1, int i) {
		return value.equalsIgnoreCase("yes");
	}
}