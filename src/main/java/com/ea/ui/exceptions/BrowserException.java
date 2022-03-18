package com.ea.ui.exceptions;


	/**
	 * Exception that is used for exception occurred while interacting with
	 * Browserstack API.
	 * 
	 * @author abogasieru@contractor.ea.com
	 *
	 */
	public class BrowserException extends RuntimeException {

		private static final long serialVersionUID = 7451733593726886517L;

		public BrowserException() {

		}

		public BrowserException(String message) {
			super(message);
		}

		public BrowserException(Throwable cause) {
			super(cause);
		}

		public BrowserException(String message, Throwable cause) {
			super(message, cause);
		}
	}

