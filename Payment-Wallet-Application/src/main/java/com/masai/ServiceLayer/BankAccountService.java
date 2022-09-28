package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Models.BankAccount;
import com.masai.Models.Wallet;

public interface BankAccountService {

	public Wallet addAccount(BankAccount bacc);
	
	public Wallet removeAccount(BankAccount bacc);
	
	
	public BankAccount viewAccount(Wallet wallet);

	public List<BankAccount> viewAllAccount(Wallet wallet);
}
