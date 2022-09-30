package com.masai.ServiceLayer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exceptions.BankAccountNotFound;
import com.masai.Exceptions.InsuficientBalance;
import com.masai.Exceptions.InvalidAccountException;
import com.masai.Exceptions.WalletNotFound;
import com.masai.Models.BankAccount;
import com.masai.Models.Customer;
import com.masai.Models.Transactions;
import com.masai.Models.Wallet;
import com.masai.Repository.BankAccountDao;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.TransactionDao;
import com.masai.Repository.WalletDao;

import jakarta.transaction.Transaction;

public class WalletServiceImpl implements WalletService{

	
	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private WalletDao walletDao;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	
	@Autowired
	private UserSessionServiceimpl userSessionsImpl;
	
	
	
	@Override
	public double showBalance(String key) throws InvalidAccountException {
		// TODO Auto-generated method stub
		
		double balance = userSessionsImpl.getCustomerWallet(key).getBalance();
		
		
		return balance;
		
	}

	@Override
	public String fundTransfer(String sourceMobileNo, String targetMobileNo, double amount, String key) {
		// TODO Auto-generated method stub
			
		Wallet sourceWallet = userSessionsImpl.getCustomerWallet(key);
		Customer sourceCustomer = userSessionsImpl.getCustomer(key);
		
		if(sourceWallet.getBalance()<amount) {
			throw new InsuficientBalance("Balance is not Sufficient in Source Wallet");
		}
		
		Optional<Customer> OptionalTargetCustomer = customerDao.findByMobileNumber(targetMobileNo);
		
		if(!OptionalTargetCustomer.isPresent()) {
			throw new BankAccountNotFound("Account does not exist with this mobile Number");
		}
		
		Customer TargetCustomer = OptionalTargetCustomer.get();
		Wallet TargetWallet = TargetCustomer.getWallet();
		sourceWallet.setBalance(sourceWallet.getBalance()-amount);
		TargetWallet.setBalance(TargetWallet.getBalance()+amount);
		
		Transactions sourceTransaction = new Transactions();
		sourceTransaction.setTransactionType("WALLETTOWALLETFOUNDTRANSFER");
		sourceTransaction.setTransactionDate(LocalDate.now());
		sourceTransaction.setAmount(amount);
		sourceTransaction.setDescription("Fund Transfer from " +sourceMobileNo+ " To "+ targetMobileNo);
		
		Transactions targetTransaction = new Transactions();
		targetTransaction.setTransactionType("WALLETTOWALLETFOUNDTRANSFER");
		targetTransaction.setTransactionDate(LocalDate.now());
		targetTransaction.setAmount(amount);
		targetTransaction.setDescription("Fund Transfer from " +sourceMobileNo+ " To "+ targetMobileNo);
		
		sourceWallet.getTranscations().add(sourceTransaction);
		TargetWallet.getTranscations().add(targetTransaction);
		
		transactionDao.save(sourceTransaction);
		transactionDao.save(targetTransaction);
		
		
		walletDao.save(sourceWallet);
		walletDao.save(TargetWallet);
		
		
		
		return "Fund is Transferred from "+sourceCustomer.getName()+ " To "+ TargetCustomer.getName();
		
	}

	@Override
	public String depositAmount(double amount, String key, Integer Accno) {
		// TODO Auto-generated method stub
		
		Wallet wallet = userSessionsImpl.getCustomerWallet(key);
		
	    BankAccount ListofBank =   bankDao.getById(Accno);

			int count = 0;
			
				if(ListofBank.getAccountNo().equals(Accno)) {
					if(wallet.getBalance()>=amount) {
						count++;
						ListofBank.setBalance(ListofBank.getBalance()+amount);
						wallet.setBalance(wallet.getBalance()-amount);
						
						bankDao.save(ListofBank);
						walletDao.save(wallet);
						
						Transactions transaction = new Transactions();
						transaction.setTransactionType("BankToWallet");
						transaction.setTransactionDate(LocalDate.now());
						transaction.setAmount(amount);
						transaction.setDescription("Fund Transfer from Wallet to Bank");
						
						wallet.getTranscations().add(transaction);
						
						transactionDao.save(transaction);
						
					}else {
						throw new InsuficientBalance("Balance is not Sufficient in Wallet");
					}
				}
			
			if(count==0) {
				throw new BankAccountNotFound("Account does not exist");
			}
			
			
			return amount+" Rupee is Credited into Bank";
		
		
	}

	@Override
	public String addMoney(double amount, String key, Integer Accno) {
		// TODO Auto-generated method stub
		
		 Wallet wallet = userSessionsImpl.getCustomerWallet(key);
			
		    BankAccount ListofBank =   bankDao.getById(Accno);
		    
				
		    
				int count = 0;
					if(ListofBank.getAccountNo().equals(Accno)) {
						if(ListofBank.getBalance()>=amount) {
							count++;
							ListofBank.setBalance(ListofBank.getBalance()-amount);
							wallet.setBalance(wallet.getBalance()+amount);
							
							
							bankDao.save(ListofBank);
							walletDao.save(wallet);
							
							Transactions transaction = new Transactions();
							transaction.setTransactionType("BankToWallet");
							transaction.setTransactionDate(LocalDate.now());
							transaction.setAmount(amount);
							transaction.setDescription("Fund Transfer from Bank to Wallet" );
							
							wallet.getTransactions().add(transaction);
							
							transactionDao.save(transaction);
							
						}else {
							throw new InsuficientBalance("Balance is not Sufficient in Bank");
						}
					}
				
				if(count==0) {
					throw new BankAccountNotFound("Account does not exist");
				}
				
				return amount+" Rupee is Credited into Wallet";
		
		
	}

	@Override
	public List<BankAccount> bankAccountByWalletId(Integer walletId) {
		// TODO Auto-generated method stub
		
		Optional<Wallet> opt =  walletDao.findById(walletId);

		if(opt==null) {
			throw new WalletNotFound("wallet not found with given wallet id "+walletId);
		}
		
		if(!opt.isPresent()) {
		
		throw new BankAccountNotFound("bank account not found with given wallet id "+walletId);
		
		}
		
		return opt.get().getBankAccount();
		
	}

	@Override
	public Customer getCustomerbyWalletId(Integer wlletId) {
		// TODO Auto-generated method stub
		
		Wallet wallet = walletDao.getById(wlletId);

		Customer customer = wallet.getCustomer();
		
		return customer;
		
		
	}

}
