package com.masai.service;

import java.util.List;

import com.masai.exceptions.BeneficiaryException;
import com.masai.model.BeneficiaryDetails;
import com.masai.model.Customer;

public interface BeneficiaryService {
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd) throws BeneficiaryException;
	public BeneficiaryDetails deleteBeneficiary(BeneficiaryDetails bd) throws BeneficiaryException;
	public BeneficiaryDetails viewBeneficiary(String mobNo) throws BeneficiaryException;
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer);
}