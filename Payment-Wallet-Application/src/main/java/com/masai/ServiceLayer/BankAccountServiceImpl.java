package com.masai.ServiceLayer;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.LoginSession.loginSession;
import com.masai.Models.BankAccount;
import com.masai.Models.Wallet;
import com.masai.Repository.BankAccountDao;
import com.masai.Repository.WalletDao;
import com.masai.Repository.loginSessionDao;


@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccDao;
	
	@Autowired
	WalletDao walletdao;
	
	@Autowired
	loginSessionDao sessionDao;
	
	@Override
	public String addAccount(BankAccount bankAccount,Integer walletId, String key) {


		   
		   Optional<loginSession> currentUser =  sessionDao.checkCustomerByUserId(key);
		   
		   if(currentUser.isPresent()) {

			  
				
				
				  Optional<Wallet> wallet =   walletdao.checkWalletById(walletId);
				   
				  if(wallet.isPresent()) {
					  wallet.get().getBankAccount().add(bankAccount);
						
	        
				
				
				
				walletdao.save(wallet.get());
					  
					  
				  }else {
					  return "wallet not found";
				  }
				  
				  
				return bankAccount.getBankName()+" is successfully added..";
		   }
		   
			return "user not found "+walletId;
}


	@Override
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws AccountNotFoundException {
	
		Optional<BankAccount> opt = bankAccDao.findById(accountNumber);
	     
		if(opt.isPresent()) {
			return opt.get();
		}
		
	    throw new BankAccountNotFound("Bank Account With not Found with given account number "+accountNumber);
	}


	@Override
	public String removeAccount(Integer accountNumber, String key) throws BankAccountNotFound {
	
	Optional<loginSession> user = sessionDao.checkCustomerByUserId(key);
		
	if(user.isPresent()) {
		 Optional<BankAccount> account =    bankAccDao.findByAccountNo(accountNumber);
		    
		  if(!account.isPresent()) {
			  throw new BankAccountNotFound("bank account not found in our database");
			  
		  }
		  
		  bankAccDao.deleteById(accountNumber);
		  
		  return "Bank Account deleted  Successfully";
	}
	
	return "wrong key";	 
	}
	
	
	

	
	@Override
	public   List<BankAccount>  viewAllBankAccountByWalletId(Integer walletId) throws BankAccountNotFound {
	
		
	Wallet wallet =	 walletdao.getById(walletId);
		
    List<BankAccount> banks =  	wallet.getBankAccount();
    
    
    return banks;
	}
	
}
