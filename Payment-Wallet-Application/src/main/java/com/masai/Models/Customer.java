package com.masai.Models;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
	
	@Id
	private Integer customerId;
	
	@NotBlank(message = "Name Of The Customer Is Mandatory")
	private String name;
	
	@Pattern(regexp = "[0-9]{10}", message = "mobile number should be 10 digit")
	private String mobileNumber;
	
	
	//(?=.*[a-z])     : This matches the presence of at least one lowercase letter.
	//(?=.*d)         : This matches the presence of at least one digit i.e. 0-9.
	//(?=.*[@#$%])  : This matches the presence of at least one special character.
	//((?=.*[A-Z])    : This matches the presence of at least one capital letter.
	//{6,16}          : This limits the length of password from minimum 6 letters to maximum 16 letters.
	
	
	@NotNull(message = "password is mandatory")
	@Pattern(regexp = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})")
	private String password;
	
	@OneToOne
	private Wallet wallet;
	
}
