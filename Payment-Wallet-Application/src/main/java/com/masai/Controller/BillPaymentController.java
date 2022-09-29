package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Models.BillingPayment;
import com.masai.ServiceLayer.BillPaymentService;

@RestController
public class BillPaymentController {
	
	@Autowired
	
	private BillPaymentService billPayService;
	

	

	@PostMapping("/Bills/{walletId}")
	public String addBill(@RequestBody BillingPayment pay, @PathVariable("walletId") Integer wallId) 
	{
		return billPayService.addBillPayment(pay,wallId);
	}
	
	
	
	@GetMapping("/Bills")
	ResponseEntity<List<BillingPayment>> getBillDetails() throws Exception{
		List<BillingPayment> bills = billPayService.viewBillPayment();
		return new ResponseEntity<>(bills, HttpStatus.OK);
		
	}
	

}
