package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.TransactionNotFoundException;
import com.masai.Models.Transactions;

import jakarta.transaction.Transaction;

public interface TransactionService {
	
	
    public Transactions addTansaction(Transaction trans);
	
	public List<Transactions> viewAllTransactions(String key,Integer walletId) throws TransactionNotFoundException;
	
	public List<Transactions> viewTransactionByDate(Integer walletId, String date)throws TransactionNotFoundException;
	
	public List<Transactions> viewAllTransactions()throws TransactionNotFoundException;
	

}
