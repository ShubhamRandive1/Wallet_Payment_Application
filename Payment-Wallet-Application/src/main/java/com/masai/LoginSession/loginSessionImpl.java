package com.masai.LoginSession;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masai.Models.Customer;
import com.masai.Models.Wallet;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.WalletDao;
import com.masai.Repository.loginSessionDao;


@Component
public class loginSessionImpl implements loginSession{

//The Dao Implementation for login session	
	
	@Autowired
	private loginSessionDao login;
	
	
// The Dao Implementation for customer
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private WalletDao walletDao;


@Override
public Wallet getTheCustomersWallet(Integer customerWallet) throws Exception {
	// TODO Auto-generated method stub
	
	Optional<loginSession> Loginsession = login.checkCustomerById(customerWallet);
	
	if(Loginsession.isEmpty()) {
		
		//throw exception
		throw new Exception(" our own exception needed here");
	}else {
		
		Customer cId = Loginsession.get().getCustomerId(customerWallet);
		
		
		Wallet wallet = walletDao.getById(customerWallet);
		
		return wallet;
				
	}
	
}


@Override
public Customer getCustomerId(Integer customerId) throws Exception {
	// TODO Auto-generated method stub
	
	Optional<loginSession> Loginsession = login.checkCustomerById(customerId);
	
	if(Loginsession.isEmpty()) {
		
		//throw exception
		throw new Exception(" our own exception needed here");
	}else {
		
		Customer cId = Loginsession.get().getCustomerId(customerId);
		
		
		
		return cId;

	}
	
}


 
	



}
