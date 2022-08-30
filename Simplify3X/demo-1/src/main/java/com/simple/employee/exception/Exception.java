package com.simple.employee.exception;

public class Exception extends RuntimeException {

	private String message;

	public Exception(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
