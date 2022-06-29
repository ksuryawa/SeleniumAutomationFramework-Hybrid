package com.ksuryawa.converters.zerocell;

import com.creditdatamw.zerocell.converter.Converter;


/**
 * @author Kapil Suryawanshi
 * 28/06/2022
 */
public class StringToIntegerConverter implements Converter<Integer> {

	@Override
	public Integer convert(String value, String s1, int i) {
		return Integer.parseInt(value);
	}
}