package com.ea.ui.exceptions;

/**
 * Exception that is used for internal exception handling
 * 
 * @author abogasieru@contractor.ea.com
 *
 */

public class WebDriverException extends RuntimeException {

	private static final long serialVersionUID = 35437563475L;

	public WebDriverException() {

	}

	public WebDriverException(String message) {
		super(message);
	}

	public WebDriverException(Throwable cause) {
		super(cause);
	}

	public WebDriverException(String message, Throwable cause) {
		super(message, cause);
	}

}
