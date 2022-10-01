package com.masai.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.SessionDao;
import com.masai.dao.TransactionDao;
import com.masai.dao.WalletDao;
import com.masai.exceptions.BeneficiaryException;
import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.TransactionNotFoundException;
import com.masai.exceptions.UserNotFoundException;
import com.masai.exceptions.WalletNotFound;
import com.masai.model.CurrentUserSession;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

@Service
public class TransactionServiceImpl implements TransactionService{


	@Autowired
	private TransactionDao tDao;
	
	@Autowired
	private WalletDao wDao;
	
	@Autowired
	private SessionDao userSessionDao;
	
	@Override
	public Transaction addTansaction(Transaction trans) throws InsufficientAmountException {
		
		
		Wallet wallet =  trans.getWallet();
		Integer wal_bal = wallet.getBalance();
		
		Integer trans_amount = (int) trans.getAmount();
		
		if(wal_bal > trans_amount) {
			
			wallet.setBalance(wal_bal - trans_amount);
			wDao.save(wallet);
			tDao.save(trans);
			
			return trans;
			
		}
		else {
			throw new InsufficientAmountException("InsufficientAmountException balance");
		}
		
		
		
		
		
		
		
		
//		
//		if(tDao.findById(trans.getTransactionId()).isEmpty()) {
//			
//			Wallet w = trans.getWallet();
//			
//			
//			
//			w.getTransactions().add(trans);
//
//			
//			return tDao.save(trans);
//			}
//		
//		
//		
//	else {
//		throw new InsufficientAmountException("InsufficientAmountException balance");
//	}
	 
		 
	}

	@Override
	public List<Transaction> viewAllTransactions(String key,Integer walletId)throws TransactionNotFoundException,UserNotFoundException, WalletNotFound{

		
		CurrentUserSession optionalUserSession = userSessionDao.findByUuid(key);
		
		if(optionalUserSession == null )
		{
			throw new UserNotFoundException("Unauthorized key");
		}
		Optional<Wallet> wallet= wDao.findByWalletId(walletId);
		if(!wallet.isPresent())
		{
			throw new WalletNotFound("Wallet not found");
		}
		else
		{
			
			List <Transaction>  transations = wallet.get().getTransactions();
			
			if(transations.size() >0)
			{
				return transations;
			}
			else
			{
				throw new TransactionNotFoundException("Transaction not found");
			}
		}
		
	}

	@Override
	public List<Transaction> viewTransactionByDate(Integer walletId, String date)throws TransactionNotFoundException, WalletNotFound {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate ld = LocalDate.parse(date, dtf);
		
		Optional<Wallet> wallet= wDao.findById(walletId);
		if(!wallet.isPresent())
		{
			throw new WalletNotFound("Wallet not found");
		}
		List <Transaction>  transations = wallet.get().getTransactions();
		
		List <Transaction>  transationsDWIthDate = new ArrayList<>();
		
		for(Transaction tc : transations )
		{
			if(tc.getTransactionDate().equals(ld))
			{
				transationsDWIthDate.add(tc);
			}
		}
		
		
		if(transationsDWIthDate.size()>0)
		{
			return transationsDWIthDate;
		}
		else
		{
			throw new TransactionNotFoundException("Transaction not found in given date");
		}
	}

	@Override
	public List<Transaction> viewAllTransactions() throws TransactionNotFoundException{
		
	
		List<Transaction> transactions =  tDao.findAll();
		if(transactions.size() >0)
		{
			return transactions;
		}
		else
		{
			throw new TransactionNotFoundException("Transaction not found");
		}
	
	}
}