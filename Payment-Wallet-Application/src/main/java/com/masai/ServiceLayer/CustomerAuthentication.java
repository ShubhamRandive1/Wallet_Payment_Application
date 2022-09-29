package com.masai.ServiceLayer;

import com.masai.DTO.CustomerDTO;

public interface CustomerAuthentication {
	
	public String login(CustomerDTO customerDTO);
	
	public String logOut(String key);

}
