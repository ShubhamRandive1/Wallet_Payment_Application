package com.masai.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.masai.exceptions.BankAccountNotFound;
import com.masai.model.BankAccount;

public interface BankAccountService {

public String addAccount(BankAccount bankAccount,Integer walletId,String key);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws BankAccountNotFound;

	public String removeAccount(Integer accountNumber,String key)throws BankAccountNotFound;
	
	
	
}
