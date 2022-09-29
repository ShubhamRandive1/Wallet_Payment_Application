package com.masai.ServiceLayer;

import com.masai.Models.Customer;

public interface CustomerService {
	
	
	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer, String key);

}
