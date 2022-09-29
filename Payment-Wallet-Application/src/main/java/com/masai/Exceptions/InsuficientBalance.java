package com.masai.Exceptions;

public class InsuficientBalance extends RuntimeException {

public InsuficientBalance() {
		
	}
	
	public InsuficientBalance(String message) {
		super(message);
	}
}
