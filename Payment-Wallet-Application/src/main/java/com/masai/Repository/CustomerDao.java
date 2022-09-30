package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	public Optional<Customer> checkByMobNumber(String mobileNumber);

	public Optional<Customer> findByMobileNumber(String mobileNumber);

}
