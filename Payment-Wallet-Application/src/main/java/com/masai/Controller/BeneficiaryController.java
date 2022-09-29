package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Models.BenificiaryDetails;
import com.masai.Models.Customer;
import com.masai.ServiceLayer.BeneficiaryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Wallet")
public class BeneficiaryController {

	
	@Autowired
	private BeneficiaryService bs;
	
	@PostMapping("/addbeneficiary")
	public ResponseEntity<BenificiaryDetails> bdStore(@Valid @RequestBody BenificiaryDetails bd) {
		
		BenificiaryDetails bdetails = bs.addBeneficiary(bd);
		
		return new ResponseEntity<BenificiaryDetails>(bdetails,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deletebeneficiary")
	public ResponseEntity<BenificiaryDetails> bdDelete(@Valid @RequestBody BenificiaryDetails bd ) {
		
		BenificiaryDetails b = bs.deleteBeneficiary(bd);
		
		return new ResponseEntity<BenificiaryDetails>(b,HttpStatus.OK);

	}
	
	@GetMapping("/viewbeneficiary/{mobileNumber}")
	public ResponseEntity<BenificiaryDetails> bdgetbyId(@Valid @PathVariable("mobileNumber") String num){
		
		BenificiaryDetails b = bs.viewBeneficiary(num);
		
		return new ResponseEntity<BenificiaryDetails>(b,HttpStatus.OK);
		
	}
	
	@PostMapping("/viewallbeneficiary")
	public ResponseEntity<List<BenificiaryDetails>> getallbd(@Valid @RequestBody Customer customer){
		
		List<BenificiaryDetails> b = bs.viewAllBeneficiary(customer);
		
		return new ResponseEntity<List<BenificiaryDetails>>(b,HttpStatus.OK);
		
	}
	
	
	
}
