package com.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shoppingcart.models.Payment;


@CrossOrigin("*")
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	

}
