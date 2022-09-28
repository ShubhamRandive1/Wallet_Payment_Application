package com.masai.LoginSession;

import com.masai.Models.Customer;
import com.masai.Models.Wallet;

public interface loginSession {
	
	//our own exception is needed for both methods
	public Wallet getTheCustomersWallet(Integer customerWallet) throws Exception;
	
	public Customer getCustomerId(Integer customerId) throws Exception;

}
