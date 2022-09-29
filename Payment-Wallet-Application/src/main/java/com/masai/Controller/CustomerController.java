package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Models.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer, @RequestBody(required = false)String key){
		
		return customerService.updateCustomer(customer, key);	
		
	}
	

}
