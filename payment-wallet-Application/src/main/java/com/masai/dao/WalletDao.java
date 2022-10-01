package com.masai.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.BankAccount;
import com.masai.model.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer> {

	public Optional<Wallet> findByWalletId(Integer walletId);
	
	public Optional<Wallet> findBybankAccount(BankAccount bankAccount);
	
}
