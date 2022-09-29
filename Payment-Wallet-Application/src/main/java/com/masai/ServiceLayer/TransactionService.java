package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.TransactionNotFoundException;

import jakarta.transaction.Transaction;

public interface TransactionService {
	
	
public Transaction addTansaction(Transaction trans);
	
	public List<Transaction> viewAllTransactions(String key,Integer walletId) throws TransactionNotFoundException;
	
	public List<Transaction> viewTransactionByDate(Integer walletId, String date)throws TransactionNotFoundException;
	
	public List<Transaction> viewAllTransactions()throws TransactionNotFoundException;
	

}
