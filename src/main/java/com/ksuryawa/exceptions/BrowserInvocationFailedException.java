package com.ksuryawa.exceptions;

/**
 * @author Kapil Suryawanshi
 * 03/07/2022
 */
public class BrowserInvocationFailedException extends FrameworkException {

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public BrowserInvocationFailedException(String message) {
		super(message);
	}

	/**
	 * Pass the message and cause that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 * @param cause  Pass the enriched stacktrace or customised stacktrace
	 */
	public BrowserInvocationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}