package com.zuhlke.interview.roman.exception;

public class UnknownNumeralException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnknownNumeralException() {
		super();
	}
	
	public UnknownNumeralException(String message) {
		super(message);
	}



}
