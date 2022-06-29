package com.ksuryawa.converters.owner;

import lombok.SneakyThrows;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * @author Kapil Suryawanshi
 * 29/06/2022
 */
public class StringToURLConverter implements Converter<URL> {
	@SneakyThrows
	@Override
	public URL convert(Method method, String stringURL) {
		return new URL(stringURL);
	}
}