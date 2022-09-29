package com.masai.Exceptions;

public class InvalidAccountException extends RuntimeException {

	public InvalidAccountException() {
		
	}
	
	public InvalidAccountException(String message) {
		super(message);
	}
}
