package com.sb.exception;

public class InsufficientBalanceException extends RuntimeException {
	public InsufficientBalanceException(String message,Exception e) {
		super(message,e);
	}
	public InsufficientBalanceException(String message) {
		super(message);
		
	}
}
