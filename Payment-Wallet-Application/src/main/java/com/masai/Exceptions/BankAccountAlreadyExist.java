package com.masai.Exceptions;

public class BankAccountAlreadyExist extends RuntimeException{
	
	
	public BankAccountAlreadyExist(String msg) {
		
		super(msg);
	}
	
	public BankAccountAlreadyExist() {
		
		
	}

}
