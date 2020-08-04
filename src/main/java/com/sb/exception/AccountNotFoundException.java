package com.sb.exception;

public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(String message,Exception e) {
		super(message,e);
	}
	public AccountNotFoundException(String message) {
		super(message);
		
	}
}
