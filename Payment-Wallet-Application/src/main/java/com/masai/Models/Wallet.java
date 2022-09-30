package com.masai.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transaction;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer walletId;
	
	@NotNull
	@Min(value = 0, message = "Balance Should Not Be In Negative")
	private double balance;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BankAccount> bankAccount;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "wallet")
	private Customer customer;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BillingPayment> billpayment;
	
	@JsonIgnore
	@OneToMany
	private List<Transactions> transcations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
	private List<BenificiaryDetails> bd = new ArrayList<>();
	

}

