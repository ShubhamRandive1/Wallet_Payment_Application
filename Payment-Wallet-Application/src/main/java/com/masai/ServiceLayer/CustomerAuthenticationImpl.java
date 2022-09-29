package com.masai.ServiceLayer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.DTO.CustomerDTO;
import com.masai.Exceptions.InvalidDetailsException;
import com.masai.LoginSession.loginSession;
import com.masai.Models.Customer;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.loginSessionDao;

public class CustomerAuthenticationImpl implements CustomerAuthentication{

	@Autowired
	UserSessionServiceimpl currentUser;
	
	
	@Autowired
	loginSessionDao sessionDao;
	
	
	@Autowired
	CustomerDao customerDao;
	
	
	
	@Override
	public String login(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		
		Optional<Customer> opt = customerDao.findByMobileNumber(customerDTO.getMobileNumber());
		
		if(!opt.isPresent()) {
			
			throw new InvalidDetailsException("Please Check the credentials");
		}
		
		Customer newCustomer1 = opt.get();
		Integer customerId1 = newCustomer1.getCustomerId();
	    Optional<loginSession> currentUser =	 sessionDao.findById(customerId1);
		
	    
	     if(newCustomer1.getPassword().equals(customerDTO.getPassword())){
	    	
	    	String key = RandomString.make(10);
	    	
	    	loginSession userSession = new loginSession(newCustomer1.getCustomerId(),LocalDateTime.now(),key);

	         sessionDao.save(userSession);
	         
	         return userSession.toString();
	    }
	    else {
	    	return "please enter a valid password";
	    }
		
	}

	@Override
	public String logOut(String key) {
		// TODO Auto-generated method stub
		
		Optional<loginSession> currentUser =	sessionDao.findById(key);
		
		 if(!currentUser.isPresent()) {

			 throw new InvalidDetailsException("Entered key is wrong");
		 }
		 
		 loginSession userSession =  this.currentUser.getCurrentLoginSessionDetails(key);
		 
		 sessionDao.delete(userSession);

		 return "Logged Out";
		
		
		
	}

}
