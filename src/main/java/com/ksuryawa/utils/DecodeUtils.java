package com.ksuryawa.utils;

import java.util.Base64;

/**
 * Helps to decode the base64 encoded string.
 *
 * @author Kapil Suryawanshi
 * 02/07/2022
 */
public final class DecodeUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DecodeUtils(){}

	/**
	 * Accepts and base64 string,decode and return to the caller
	 *
	 * @author Kapil Suryawanshi
	 * 02/07/2022
	 * @param encodedString Base64 encoded string
	 * @return String Decoded base64 string
	 */
	public static String getDecodedString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
}