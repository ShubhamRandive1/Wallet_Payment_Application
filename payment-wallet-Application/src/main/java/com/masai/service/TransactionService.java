package com.masai.service;

import java.util.List;

import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.TransactionNotFoundException;
import com.masai.exceptions.UserNotFoundException;
import com.masai.exceptions.WalletNotFound;
import com.masai.model.Transaction;

public interface TransactionService {

	

	public Transaction addTansaction(Transaction trans) throws InsufficientAmountException;
	
	public List<Transaction> viewAllTransactions(String key,Integer walletId) throws TransactionNotFoundException, UserNotFoundException, WalletNotFound;
	
	public List<Transaction> viewTransactionByDate(Integer walletId, String date)throws TransactionNotFoundException, WalletNotFound;
	
	public List<Transaction> viewAllTransactions()throws TransactionNotFoundException;
}
