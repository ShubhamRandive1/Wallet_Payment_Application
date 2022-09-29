package com.masai.Exceptions;

public class InvalidDetailsException extends RuntimeException{

	public InvalidDetailsException() {
		
	}
	
	public InvalidDetailsException(String message) {
		super(message);
	}
	
}
