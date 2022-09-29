package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.InvalidAccountException;
import com.masai.Models.BankAccount;
import com.masai.Models.Customer;

public interface WalletService {
	
	
	public double showBalance(String key) throws InvalidAccountException;
	
	public String fundTransfer(String sourceMobileNo, String targetMobileNo, double amount,String key);
	
	public String depositAmount(double amount, String key, Integer Accno);
	
	public String addMoney(double amount, String key,Integer Accno);
	
	public List<BankAccount> bankAccountByWalletId(Integer walletId);
	
	public Customer getCustomerbyWalletId(Integer wlletId);
	

}
