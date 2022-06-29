package com.ksuryawa.converters.zerocell;

import com.creditdatamw.zerocell.converter.Converter;
import com.ksuryawa.enums.BrowserType;

/**
 * @author Kapil Suryawanshi
 * 28/06/2022
 */
public class StringToBrowserTypeConverter implements Converter<BrowserType> {

	@Override
	public BrowserType convert(String value, String s1, int i) {
		return BrowserType.valueOf(value.toUpperCase());
	}
}