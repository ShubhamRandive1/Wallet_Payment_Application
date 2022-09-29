package com.masai.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	
	
	@Pattern(regexp = "[0-9]{10}", message = "Enter Valid Mobile Number")
	private String mobileNumber;
	
	@NotNull(message = "password is mandatory")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$")
	private String password;
	

}
