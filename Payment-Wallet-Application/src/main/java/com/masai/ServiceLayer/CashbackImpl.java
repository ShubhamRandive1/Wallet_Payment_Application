package com.masai.ServiceLayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Models.BillingPayment;
import com.masai.Models.Wallet;
import com.masai.Repository.BillingPaymentDao;
import com.masai.Repository.CashBackDao;
import com.masai.Repository.WalletDao;

public class CashbackImpl implements Cashback{

	
	@Autowired
	BillingPaymentDao billPaymentDao;
	
	@Autowired
	CashBackDao cashbackDao;
	
	@Autowired
	WalletService walletService;
	
	@Autowired
	WalletDao walletdao;
	
	
	@Override
	public String Calculatecashback(Integer billId, Integer walletId, String promocode) {
		// TODO Auto-generated method stub
		
		
		Optional<Cashback> cash =  cashbackDao.findByPromocode(promocode);
		
		 
		 int val = 0;
		 int cashbankPercentage = 0;
		 double prevBal = 0;
		 double currentBal = 0;
		 double amount;
		 
		 if(cash!=null) {
			
			 int max = 25;
			 int min = 5;
			 
			 int range = max - min +1;
			 
			 for(int i=0; i<25; i++) {
				  val = (int) (Math.random()*range)+min;
			 }
			 
		      BillingPayment bill = billPaymentDao.getById(billId);
			 
		      amount =   bill.getAmount();
		
			 cashbankPercentage = (int) ((amount*val)/100);
			 
			 System.out.println(amount+"aaaaaaaaaaaaaa");
			 
			 System.out.println(val);
			 //System.out.println(cashbankPercentage+"sssssss");
			 //System.out.println(val);
		 }
		 
		 else {
			 return "wrong key";
		 }
		 
		 
	       Wallet wallet =   walletdao.getById(walletId);
	    
	       if(wallet.getWalletId().equals(walletId)) {
	    	  
	    	   prevBal = wallet.getBalance();
	    	   
	    	   wallet.setBalance(wallet.getBalance()+cashbankPercentage);

	    	   walletdao.save(wallet);
	    	   
	    	   currentBal = wallet.getBalance();
	    	   
	       }
	       else {
	    	   return "wallet not found";
	       }
	 
		 
		 
		 
		 return "Hurray!! you got cashback of "+val+" percent"+" "
		+"and total cashback ammount is " +": "+cashbankPercentage+ "\n" +
		 "Previous wallet balance was "+ prevBal +"\n" + 
		 "Updated wallet balance is "+ currentBal;
		
		
		
		
	}

}
