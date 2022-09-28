package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer>{
	
	public Optional<Wallet> checkWalletById(Integer walletId);

}
