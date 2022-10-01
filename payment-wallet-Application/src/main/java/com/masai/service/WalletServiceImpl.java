package com.masai.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.BankAccountDao;
import com.masai.dao.CustomerDao;
import com.masai.dao.SessionDao;
import com.masai.dao.TransactionDao;
import com.masai.dao.WalletDao;
import com.masai.exceptions.BankAccountNotFound;
import com.masai.exceptions.InsufficientAmountException;
import com.masai.model.BankAccount;
import com.masai.model.Customer;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private SessionDao sDao;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	
	
	@Override
	public Integer showBalance(String key) {
		
		Integer UserId = sDao.findByUuid(key).getUserId();
		Optional<Customer> customer = customerDao.findById(UserId);
		
		Integer balance = customer.get().getWallet().getBalance();
			return balance;
		
	}
	
	

	@Override
	public String addMoney(Integer amount, String key,Integer Accno) throws BankAccountNotFound, InsufficientAmountException {
    
		Integer UserId = sDao.findByUuid(key).getUserId();
		Optional<Customer> customer = customerDao.findById(UserId);
		
		Wallet wallet = customer.get().getWallet();
		
		
		
		 
		
    BankAccount ListofBank =   bankDao.getById(Accno);
    
		
    
		int count = 0;
			if(ListofBank.getAccountNo().equals(Accno)) {
				if(ListofBank.getBalance()>=amount) {
					count++;
					ListofBank.setBalance(ListofBank.getBalance()-amount);
					wallet.setBalance(wallet.getBalance()+amount);
					
					
					bankDao.save(ListofBank);
					walletDao.save(wallet);
					
					Transaction transaction = new Transaction();
					transaction.setTransactionType("BankToWallet");
					transaction.setTransactionDate(LocalDate.now());
					transaction.setAmount(amount);
					transaction.setDescription("Fund Transfer from Bank to Wallet" );
					
					wallet.getTransactions().add(transaction);
					
					transactionDao.save(transaction);
					
				}else {
					throw new InsufficientAmountException("Balance is not Sufficient in Bank");
				}
			}
		
		if(count==0) {
			throw new BankAccountNotFound("Account does not exist");
		}
		
		return amount+" Rupee is Credited into Wallet";
	}


	


	@Override
	public String depositAmount(Integer amount, String key, Integer Accno) throws BankAccountNotFound, InsufficientAmountException {
		Integer UserId = sDao.findByUuid(key).getUserId();
		Optional<Customer> customer = customerDao.findById(UserId);
		
		Wallet wallet = customer.get().getWallet();
		
		
	    BankAccount ListofBank =   bankDao.getById(Accno);

			int count = 0;
			
				if(ListofBank.getAccountNo().equals(Accno)) {
					if(wallet.getBalance()>=amount) {
						count++;
						ListofBank.setBalance(ListofBank.getBalance()+amount);
						wallet.setBalance(wallet.getBalance()-amount);
						
						bankDao.save(ListofBank);
						walletDao.save(wallet);
						
						Transaction transaction = new Transaction();
						transaction.setTransactionType("BankToWallet");
						transaction.setTransactionDate(LocalDate.now());
						transaction.setAmount(amount);
						transaction.setDescription("Fund Transfer from Wallet to Bank");
						
						wallet.getTransactions().add(transaction);
						
						transactionDao.save(transaction);
						
					}else {
						throw new InsufficientAmountException("Balance is not Sufficient in Wallet");
					}
				}
			
			if(count==0) {
				throw new BankAccountNotFound("Account does not exist");
			}
			
			
			return amount+" Rupee is Credited into Bank";

	}



	@Override
	public Customer getCustomerbyWalletId(Integer walletId) {
		Wallet wallet = walletDao.getById(walletId);

		Customer customer = wallet.getCustomer();
		
		return customer;
	}
	
	
	
}
