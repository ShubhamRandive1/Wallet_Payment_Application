package com.masai.Controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Models.BankAccount;
import com.masai.ServiceLayer.BankAccountService;
import com.masai.ServiceLayer.WalletService;

import jakarta.validation.Valid;

@RestController
public class BankAccountController {
	
	@Autowired
    private BankAccountService bankService;
	
	@Autowired
	WalletService walletService;

	
	@PostMapping("/banks/{walletId}")
	ResponseEntity<String> addAccount(@Valid @RequestBody BankAccount bankAccount,@PathVariable Integer walletId, @RequestParam String key){
		
		
	return new ResponseEntity<String>(bankService.addAccount(bankAccount,walletId,key),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/bank/{accountNumber}")
	ResponseEntity<BankAccount> searchBankAccountByAccountNo(@PathVariable Integer accountNumber) throws AccountNotFoundException{
		
	BankAccount bankacc =	bankService.getAccountByAccountNumber(accountNumber);
		
	return new ResponseEntity<>(bankacc,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/bank/{accountNumber}")
	ResponseEntity<String> deleteBankAccount(@PathVariable Integer accountNumber, @RequestParam String key){
		
		
	 String bankacc = 	bankService.removeAccount(accountNumber,key);
		
	 return new ResponseEntity<String>(bankacc,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/wallet/{walletId}")
	ResponseEntity<List<BankAccount>> BankByWalletId(@PathVariable Integer walletId){
		
//	List<BankAccount> bankaccount =	walletService.bankAccountByWalletId(walletId);
	
   List<BankAccount> bankaccount =  bankService.viewAllBankAccountByWalletId(walletId);		
	return new ResponseEntity<List<BankAccount>>(bankaccount,HttpStatus.OK);
	
	}
	
	

}
