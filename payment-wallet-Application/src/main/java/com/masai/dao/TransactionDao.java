package com.masai.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Transaction;
import com.masai.model.TransactionType;
import com.masai.model.Wallet;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {
	
	public List<Transaction> findByTransactionType(TransactionType transactionType);
	
//	public List<Transaction> findByWallet(Wallet wallet);
}