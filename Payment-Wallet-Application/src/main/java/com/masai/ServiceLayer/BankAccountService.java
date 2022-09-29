package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Models.BankAccount;
import com.masai.Models.Wallet;

public interface BankAccountService {

	public String addAccount(BankAccount bankAccount,Integer walletId,String key);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws AccountNotFoundException;

	public String removeAccount(Integer accountNumber,String key)throws BankAccountNotFound;
	
	public List<BankAccount> viewAllBankAccountByWalletId(Integer walletId) throws BankAccountNotFound;
	

}
