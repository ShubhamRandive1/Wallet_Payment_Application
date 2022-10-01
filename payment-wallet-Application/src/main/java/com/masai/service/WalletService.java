package com.masai.service;

import com.masai.exceptions.BankAccountNotFound;
import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;

public interface WalletService {

	
	public Integer showBalance(String key) throws InvalidAccountException;
	
//public String fundTransfer(String sourceMobileNo, String targetMobileNo, double amount,String key);
	
	public String depositAmount(Integer amount, String key, Integer Accno) throws BankAccountNotFound, InsufficientAmountException;
	
	public String addMoney(Integer amount, String key,Integer Accno) throws BankAccountNotFound, InsufficientAmountException;
	

	
	public Customer getCustomerbyWalletId(Integer walletId);
	
}
