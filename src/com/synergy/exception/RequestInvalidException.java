package com.synergy.exception;

public class RequestInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequestInvalidException() {
		super();
	}

	public RequestInvalidException(String message) {
		super(message);
	}

	public RequestInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestInvalidException(Throwable ex) {
		super(ex);
	}

}
