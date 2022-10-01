package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BankAccountNotFound;
import com.masai.exceptions.InsufficientAmountException;
import com.masai.exceptions.InvalidAccountException;
import com.masai.model.Customer;
import com.masai.service.WalletService;

@RestController
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	
	@GetMapping("/showbalance")
	public Integer showBalanceController(@RequestParam(required = false) String key) throws InvalidAccountException {
		
		return walletService.showBalance(key);
		

	}
	
	
	@PostMapping("addmoney/{amount}/{Accno}")
	public ResponseEntity<String> addMoneyController(@PathVariable Integer amount, @RequestParam(required = false) String key,@PathVariable Integer Accno) throws BankAccountNotFound, InsufficientAmountException {
		
		String message =  walletService.addMoney(amount, key, Accno);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);

	}
	
	
	@PostMapping("depositmoney/{amount}/{Accno}")
	public ResponseEntity<String> depositMoneyController(@PathVariable Integer amount, @RequestParam(required = false) String key,@PathVariable Integer Accno) throws BankAccountNotFound, InsufficientAmountException {
		
		String message =  walletService.depositAmount(amount, key, Accno);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);

	}
	
	
	@GetMapping("getcustomerbywalletid/{walletId}")
	public ResponseEntity<Customer> getCustomerController(@PathVariable Integer walletId) {
		
		Customer customer = walletService.getCustomerbyWalletId(walletId);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
		
	}

	
	
	
}
