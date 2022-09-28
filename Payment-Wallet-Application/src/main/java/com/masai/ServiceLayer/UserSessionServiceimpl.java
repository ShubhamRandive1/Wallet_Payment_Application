package com.masai.ServiceLayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.LoginSession.loginSession;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.loginSessionDao;

@Service
public class UserSessionServiceimpl implements UserSessionService{
	
	@Autowired
	private loginSessionDao loginDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	

	@Override
	public loginSession getCurrentLoginSessionDetails(String customerDetail) {
		// TODO Auto-generated method stub
		
		Optional<loginSession> optionalLogin  = loginDao.checkCustomerByUserId(customerDetail);
		
		if(optionalLogin.isEmpty()) {
			
			System.out.println("User Details Not Found");
				
		}
		
		return optionalLogin.get();
	}

}
