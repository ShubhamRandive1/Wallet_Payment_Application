package com.masai.ServiceLayer;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.masai.Exceptions.BankAccountNotFound;
import com.masai.Models.BankAccount;

public interface BankAccountService {

	public String addAccount(BankAccount bankAccount,Integer walletId,String key);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws AccountNotFoundException;

	public String removeAccount(Integer accountNumber,String key)throws BankAccountNotFound;
	
	public List<BankAccount> viewAllBankAccountByWalletId(Integer walletId) throws BankAccountNotFound;
	

}
