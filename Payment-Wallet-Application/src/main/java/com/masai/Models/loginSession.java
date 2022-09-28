package com.masai.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class loginSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginSessionId;
	
	
	@Column(unique = true)
	private Integer customerId;
	
	private String loginUserId;
	
	private LocalDateTime localDateTime;

	public loginSession(Integer customerId, String loginUserId, LocalDateTime localDateTime) {
		super();
		this.customerId = customerId;
		this.loginUserId = loginUserId;
		this.localDateTime = localDateTime;
	}
	
	
	

}
