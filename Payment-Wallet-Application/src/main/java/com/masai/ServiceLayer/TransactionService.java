package com.masai.ServiceLayer;

import java.time.LocalDate;
import java.util.List;

import com.masai.Models.Wallet;

import jakarta.transaction.Transaction;
import jakarta.transaction.TransactionalException;


public interface TransactionService {
	public Transaction addTransaction(Transaction transaction)throws TransactionalException;
	public List<Transaction> viewAllTransactionsByWallet(Wallet wellet)throws TransactionalException;
	public List<Transaction> viewTransactionsByDate(LocalDate from, LocalDate to)throws TransactionalException;
	public List<Transaction> viewAllTransactions(String type)throws TransactionalException;
}
