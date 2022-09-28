package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{

}
