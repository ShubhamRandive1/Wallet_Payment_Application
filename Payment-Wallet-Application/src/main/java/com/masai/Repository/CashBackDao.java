package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Models.CashBack;
import com.masai.ServiceLayer.Cashback;

public interface CashBackDao extends JpaRepository<CashBack, Integer> {

	public Optional<Cashback> findByPromocode(String promocode);

}
