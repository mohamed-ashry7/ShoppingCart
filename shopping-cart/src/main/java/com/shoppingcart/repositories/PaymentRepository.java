package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	

}
