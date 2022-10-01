package com.masai.model;

 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String mobileNo;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
	
	
	
	

}
