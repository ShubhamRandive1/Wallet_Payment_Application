package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.BankAccountDao;
import com.masai.dao.SessionDao;
import com.masai.dao.WalletDao;
import com.masai.exceptions.BankAccountNotFound;
import com.masai.model.BankAccount;
import com.masai.model.CurrentUserSession;
import com.masai.model.Wallet;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	BankAccountDao bankAccDao;
	
	@Autowired
	WalletDao walletdao;
	
	@Autowired
	SessionDao sessionDao;
	
	
	@Override
	public String addAccount(BankAccount bankAccount, Integer walletId, String key) {
		CurrentUserSession currentUser =  sessionDao.findByUuid(key);
		
		if(currentUser != null) {

			  
			
			
			  Optional<Wallet> wallet =   walletdao.findByWalletId(walletId);
			   
			  if(wallet.isPresent()) {
				  wallet.get().setBankAccount(bankAccount);
      
			
			
			
			walletdao.save(wallet.get());
				  
				  
			  }else {
				  return "wallet not found";
			  }
			  
			  
			return bankAccount.getBankName()+" is successfully added..";
	   }
	   
		return "user not found "+walletId;
}

		
		
		
	

	@Override
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws BankAccountNotFound {
		
		Optional<BankAccount> bankAccount = bankAccDao.findById(accountNumber);
		
		
		
		
		return bankAccount.get();
	}

	@Override
	public String removeAccount(Integer accountNumber, String key) throws BankAccountNotFound {
		
		CurrentUserSession currentUser =  sessionDao.findByUuid(key);
		
		if(currentUser != null) {
			
			Optional<BankAccount> bankAccount = bankAccDao.findById(accountNumber);
			
			  Wallet wallet =  bankAccount.get().getWallet();
			
			  wallet.setBankAccount(null);
			
			  return bankAccount.get().getBankName()+" succesfully removed";
		}
		
		
		return "Bank Account not removed";
	}


}
