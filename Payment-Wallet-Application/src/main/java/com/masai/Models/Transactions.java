package com.masai.Models;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @Entity
 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private String transactionType;
		
	@CreatedDate
	@CreationTimestamp
	@JsonFormat(pattern = "dd-mm-yyyy")
	private LocalDateTime transactionDate;
		
	@OneToOne
	private Wallet wallet;
	private Integer amount;
	private String description;

}
