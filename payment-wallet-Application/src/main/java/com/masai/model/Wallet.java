package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	private Integer balance;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "wallet")
	private Customer customer;
	 
	@OneToOne(cascade = CascadeType.ALL)
	private  BankAccount bankAccount;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , mappedBy="wallet")
	private List<Transaction> transactions = new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BillPayment> billpayment = new ArrayList<>();
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "wallet")
	@JsonIgnore
	private List<BeneficiaryDetails> bd = new ArrayList<>();
	
	
	
}
