package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.BeneficiaryDetails;

public interface BeneficiaryDao extends JpaRepository<BeneficiaryDetails, String>{

}