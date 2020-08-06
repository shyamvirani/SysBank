package com.sb.exception;

public class LoanNotFoundException extends RuntimeException {
	public LoanNotFoundException(String message,Exception e) {
		super(message,e);
	}
	public LoanNotFoundException(String message) {
		super(message);
		
	}
}
