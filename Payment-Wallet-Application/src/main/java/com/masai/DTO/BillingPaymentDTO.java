package com.masai.DTO;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingPaymentDTO {
	private Integer billId;
	private String billType;
	private double amount;
	private LocalDate paymentDate;
}
