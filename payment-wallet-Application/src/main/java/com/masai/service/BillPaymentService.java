package com.masai.service;

import java.util.List;

import com.masai.exceptions.BillPaymentNotFoundException;
import com.masai.model.BillPayment;

public interface BillPaymentService {

	

	public String addBillPayment(BillPayment payment, Integer wallId);
	
	public List<BillPayment> viewBillPayment() throws BillPaymentNotFoundException;
	
}
