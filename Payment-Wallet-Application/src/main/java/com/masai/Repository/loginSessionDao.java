package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.LoginSession.loginSession;

@Repository
public interface loginSessionDao extends JpaRepository<loginSession, Integer>{
	
	public Optional<loginSession> checkCustomerById(Integer customerId);
	
	
	public Optional<loginSession> checkCustomerByUserId(String customerUserId);
	
	
	public void registerCustomer(String customerUserId);

}
