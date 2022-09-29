package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Models.BenificiaryDetails;
import com.masai.Models.Customer;

public interface BeneficiaryService {
	
	public BenificiaryDetails addBeneficiary(BenificiaryDetails bd);
	
	public BenificiaryDetails deleteBeneficiary(BenificiaryDetails bd);
	
	public BenificiaryDetails viewBeneficiary(String mobNo);
	
	public List<BenificiaryDetails> viewAllBeneficiary(Customer customer);
	

}
