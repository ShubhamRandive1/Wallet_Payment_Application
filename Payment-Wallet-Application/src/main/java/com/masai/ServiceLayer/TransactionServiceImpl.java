package com.masai.ServiceLayer;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Models.Wallet;

import jakarta.transaction.Transaction;
import jakarta.transaction.TransactionalException;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Override
	public Transaction addTransaction(Transaction transaction) throws TransactionalException {
		
		return null;
	}

	@Override
	public List<Transaction> viewAllTransactionsByWallet(Wallet wellet) throws TransactionalException {
		
		return null;
	}

	@Override
	public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to) throws TransactionalException {
		
		return null;
	}

	@Override
	public List<Transaction> viewAllTransactions(String type) throws TransactionalException {
		
		return null;
	}

}
