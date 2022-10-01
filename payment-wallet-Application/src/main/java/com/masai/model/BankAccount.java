package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class BankAccount {

	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountNo;
	
//	@NotNull
//	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}")
	private String ifscCode;
	
	@NotNull
	private String bankName;
	
	@NotNull
	@Min(0)
	private double balance;
	
	
	
	@OneToOne(cascade = CascadeType.ALL )
	private Wallet wallet;
	
	
	
}
