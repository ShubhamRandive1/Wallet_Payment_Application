package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.BankAccount;

public interface BankAccountDao extends JpaRepository<BankAccount, Integer>{
  
  
	public BankAccount findByBankNameAndWallet(String bankName, Integer Id);
	
	public Optional<BankAccount> findById(Integer accountNo);
	
	public Optional<BankAccount> findByAccountNo(Integer accountNo);


}
