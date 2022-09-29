package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Models.BillingPayment;

public interface BillPaymentService {
	public BillingPayment addBillPayment(BillingPayment payment, Integer wallId) throws Exception;

	public List<BillingPayment> viewBillPayment() throws Exception;

}
