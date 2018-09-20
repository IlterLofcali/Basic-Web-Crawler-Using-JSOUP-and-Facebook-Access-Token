package com.ilter.main;

public class CustomException extends Exception {

	String errorType;

	public CustomException(String string, Exception e) {
		// calls Exception default constructor
		super(string, e);
	}

	public CustomException() {
	}
}
