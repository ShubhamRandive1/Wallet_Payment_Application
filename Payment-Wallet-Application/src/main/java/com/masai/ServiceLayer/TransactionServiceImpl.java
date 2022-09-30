package com.masai.ServiceLayer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class TransactionServiceImpl implements TransactionService{

	
	@Autowired
	private loginSessionDao userSessionDao;
	
	@Autowired
	private TransactionDao tDao;
	
	@Autowired
	private WalletDao wDao;
	
	
	
	@Override
	public Transactions addTansaction(Transaction trans) {
		// TODO Auto-generated method stub
		Wallet wallet = ((Transactions) trans).getWallet();
		
		Transactions transactions = tDao.save(trans);
		((Transactions) transactions).setWallet(wallet);
		
		return transactions;
	}

	@Override
	public List<Transactions> viewAllTransactions(String key, Integer walletId) throws TransactionNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<loginSession> optionalUserSession = userSessionDao.checkCustomerByUserId(key);
		
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
			List <Transactions>  transations = wallet.get().getTranscations();
			
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
	public List<Transactions> viewTransactionByDate(Integer walletId, String date) throws TransactionNotFoundException {
		// TODO Auto-generated method stub
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate ld = LocalDate.parse(date, dtf);
		
		Optional<Wallet> wallet= wDao.findById(walletId);
		if(!wallet.isPresent())
		{
			throw new WalletNotFound("Wallet not found");
		}
		List <Transactions>  transations = wallet.get().getTranscations();
		
		List <Transactions>  transationsDWIthDate = new ArrayList<>();
		
		for(Transactions tc : transations )
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
	public List<Transactions> viewAllTransactions() throws TransactionNotFoundException {
		// TODO Auto-generated method stub
		
		List<Transactions> transactions =  tDao.findAll();
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
