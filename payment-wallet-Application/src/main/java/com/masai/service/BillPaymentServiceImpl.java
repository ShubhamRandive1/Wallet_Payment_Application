package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.BillPaymentDao;
import com.masai.dao.SessionDao;
import com.masai.dao.WalletDao;
import com.masai.exceptions.BillPaymentNotFoundException;
import com.masai.model.BillPayment;
import com.masai.model.Transaction;
import com.masai.model.Wallet;

@Service
public class BillPaymentServiceImpl implements BillPaymentService  {

	
	@Autowired
	private WalletDao wDao;
	
	@Autowired
	private BillPaymentDao billDao;
	
	@Autowired
	private TransactionServiceImpl trService;
	
	@Autowired
	private SessionDao sessionDao;
	
	
 




@Override
public String addBillPayment(BillPayment payment, Integer wallId) {
Wallet wallet =payment.getWallet();//100


Transaction tr = new Transaction();

tr.setAmount(payment.getAmount());
tr.setDescription(payment.getBillType());
tr.setTransactionDate(LocalDate.now());

//Integer wallId =2;

Double debitamt = payment.getAmount();
Wallet w1;
Double bal;
String promo = null ;
int count =0;
//
//Optional<Wallet> opt = wDao.findByWalletId(wallId);
//if(opt.isPresent()) {
//w1 =opt.get();
//bal =w1.getbalance();
//if(bal>=debitamt) {
//
//count++;
//
//
//
//w1.setBalance(bal-debitamt);
//wDao.save(w1);
//trService.addTansaction(tr);
//
//
//
//
//
//}
//}
//
//else{
//throw new BillPaymentNotFoundException("Insufficient amount ");
//}



billDao.save(payment);

return "Payment Done Successfully..."+"\n";

}


	@Override
	public List<BillPayment> viewBillPayment() throws BillPaymentNotFoundException {
		
		List<BillPayment> billList = billDao.findAll();
		if(billList.size()==0) {
			throw new BillPaymentNotFoundException("No BillPaymets in the List ");
		}
		
				
		return billList;
	}


	

	
}
