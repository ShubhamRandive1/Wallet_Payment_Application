package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.BankAccount;

public interface BankAccountDao extends JpaRepository<BankAccount, Integer>{

}
