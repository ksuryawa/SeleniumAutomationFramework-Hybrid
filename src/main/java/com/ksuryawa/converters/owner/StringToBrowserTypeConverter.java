package com.ksuryawa.converters.owner;

import com.ksuryawa.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Kapil Suryawanshi
 * 29/06/2022
 */
public class StringToBrowserTypeConverter implements Converter<BrowserType> {
	@Override
	public BrowserType convert(Method method, String browserName) {
		Map<String, BrowserType> stringBrowserTypeMap = Map.
				of("CHROME", BrowserType.CHROME,
						"FIREFOX", BrowserType.FIREFOX,
						"SAFARI", BrowserType.SAFARI);

		return stringBrowserTypeMap
				.getOrDefault(browserName.toUpperCase(),BrowserType.CHROME);
	}


}