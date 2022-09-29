package com.masai.ServiceLayer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exceptions.TransactionNotFoundException;
import com.masai.Exceptions.UserNotFoundException;
import com.masai.Exceptions.WalletNotFound;
import com.masai.LoginSession.loginSession;
import com.masai.Models.Transactions;
import com.masai.Models.Wallet;
import com.masai.Repository.TransactionDao;
import com.masai.Repository.WalletDao;
import com.masai.Repository.loginSessionDao;

import jakarta.transaction.Transaction;

public class TransactionServiceImpl implements TransactionService{

	
	@Autowired
	private loginSessionDao userSessionDao;
	
	@Autowired
	private TransactionDao tDao;
	
	@Autowired
	private WalletDao wDao;
	
	
	
	@Override
	public Transaction addTansaction(Transaction trans) {
		// TODO Auto-generated method stub
		Wallet wallet = ((Transactions) trans).getWallet();
		
		Transaction transactions = tDao.save(trans);
		((Transactions) transactions).setWallet(wallet);
		
		return transactions;
	}

	@Override
	public List<Transaction> viewAllTransactions(String key, Integer walletId) throws TransactionNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<loginSession> optionalUserSession = userSessionDao.findById(key);
		
		if(!optionalUserSession.isPresent())
		{
			throw new UserNotFoundException("Unauthorized key");
		}
		else
		{
			Optional<Wallet> wallet= wDao.findById(walletId);
			if(!wallet.isPresent())
			{
				throw new WalletNotFound("Wallet not found");
			}
			List <Transaction>  transations = wallet.get().getTranscations();
			
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
	public List<Transaction> viewTransactionByDate(Integer walletId, String date) throws TransactionNotFoundException {
		// TODO Auto-generated method stub
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate ld = LocalDate.parse(date, dtf);
		
		Optional<Wallet> wallet= wDao.findById(walletId);
		if(!wallet.isPresent())
		{
			throw new WalletNotFound("Wallet not found");
		}
		List <Transaction>  transations = wallet.get().getTranscations();
		
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
	public List<Transaction> viewAllTransactions() throws TransactionNotFoundException {
		// TODO Auto-generated method stub
		
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
