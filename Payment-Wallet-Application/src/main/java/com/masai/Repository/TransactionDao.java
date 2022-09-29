package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.Transactions;

public interface TransactionDao extends JpaRepository<Transactions, Integer> {

	
}
