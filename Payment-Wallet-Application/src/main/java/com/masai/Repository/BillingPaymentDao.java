package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Models.BillingPayment;

@Repository
public interface BillingPaymentDao extends JpaRepository<BillingPayment, Integer> {

}
