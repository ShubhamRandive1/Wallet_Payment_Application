package com.masai.ServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Models.BillingPayment;
import com.masai.Models.Transactions;
import com.masai.Models.Wallet;
import com.masai.Repository.BillingPaymentDao;
import com.masai.Repository.TransactionDao;
import com.masai.Repository.WalletDao;


@Service
public class BillPaymentServiceImpl implements BillPaymentService {
	@Autowired
	private WalletDao walletDao;

	@Autowired
	private BillingPaymentDao billingPaymentDao;

	private TransactionDao transactionDao;

	@Override
	public BillingPayment addBillPayment(BillingPayment payment, Integer wallId) throws Exception {
		if (payment.getAmount() < 0)
			throw new Exception("amount should be more then zero");
		Optional<Wallet> opt = walletDao.findById(wallId);
		Transactions transaction = new Transactions();
		if (opt.isPresent()) {
			Wallet walletext = opt.get();

			if (walletext.getBalance() >= payment.getAmount()) {
				walletext.setBalance(walletext.getBalance() - payment.getAmount());
				transaction.setTransactionType(payment.getBillType());
				transaction.setTransactionDate(payment.getPaymentDate());
				transaction.setAmount(payment.getAmount());
				transaction.setWallet(walletext);
				walletDao.save(walletext);
				billingPaymentDao.save(payment);
				transactionDao.save(transaction);
				return payment;

			} else {
				throw new Exception("No balance");
			}

		} else {
			throw new Exception("Wallet Not found");
		}
		return null;
	}

	@Override
	public List<BillingPayment> viewBillPayment() throws Exception {
		List<BillingPayment> list = billingPaymentDao.findAll();
		if (list.size() > 0) {
			return list;
		} else {
			throw new Exception("BilingPayments Not found");
		}

	}

}
