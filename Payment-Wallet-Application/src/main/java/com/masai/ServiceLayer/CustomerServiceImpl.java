package com.masai.ServiceLayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.LoginSession.loginSession;
import com.masai.Models.Customer;
import com.masai.Repository.CustomerDao;

public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	UserSessionServiceimpl currentuser;
	
	
	@Autowired
    private CustomerDao customerDao;
	
	

	@Override
	public Customer createCustomer(Customer customer) {
		
		// TODO Auto-generated method stub
		 Optional<Customer> opt = customerDao.findByMobileNumber(customer.getMobileNumber());
			
		   if(opt.isPresent()){
			  System.out.println("User Already Exist"); 
		   }
		   
		   
		   
		   return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) {
		// TODO Auto-generated method stub
		
		loginSession customer2 =	currentuser.getCurrentLoginSessionDetails(key);
		
		  if(customer2==null) {
			  System.out.println("no user found");
		  }

		 
		  
		  return customerDao.save(customer);
		
		
		
	}

}
