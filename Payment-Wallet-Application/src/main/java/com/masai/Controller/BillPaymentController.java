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
	public ResponseEntity<BillingPayment> addBill(@RequestBody BillingPayment pay,
			@PathVariable("walletId") Integer wallId) throws Exception {
		BillingPayment bp = billPayService.addBillPayment(pay, wallId);
		return new ResponseEntity<BillingPayment>(bp, HttpStatus.CREATED);
	}

	@GetMapping("/Bills")
	ResponseEntity<List<BillingPayment>> getBillDetails() throws Exception {
		List<BillingPayment> bills = billPayService.viewBillPayment();
		return new ResponseEntity<List<BillingPayment>>(bills, HttpStatus.OK);

	}

}
