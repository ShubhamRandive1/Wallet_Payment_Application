package com.masai.ServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Models.BankAccount;
import com.masai.Models.Wallet;
import com.masai.Repository.BankAccountDao;

public class BankAccountServiceImpl implements  BankAccountService {

	@Autowired
	private BankAccountDao BADAO;

	@Override
	public Wallet addAccount(BankAccount bacc) {
		
		BankAccount bankAccount = BADAO.save(bacc);
  
		Wallet wallet =	bankAccount.getWallet();
		return wallet;
	}

	@Override
	public Wallet removeAccount(BankAccount bacc) {
		Optional<BankAccount> bankAccount  = BADAO.findById(bacc.getAccountNo());
		
		if(bankAccount.get() != null) {
			BADAO.delete(bacc);
			
			return bankAccount.get().getWallet();
		}
		else {
			throw new BankAccountException("Bank Account with this a/n does't exist : "+bacc.getAccountNo());
		}
		
		
		

	}

	@Override
	public BankAccount viewAccount(Wallet wallet) {
		return null;
	}

	@Override
	public List<BankAccount> viewAllAccount(Wallet wallet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
