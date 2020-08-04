package com.sb.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message,Exception e) {
		super(message,e);
	}
	public CustomerNotFoundException(String message) {
		super(message);
		
	}
}
