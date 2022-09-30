package com.masai.Models;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;

	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

	private String billType;

	private double amount;

	@CreatedDate
	@CreationTimestamp
	private LocalDate paymentDate;
}
