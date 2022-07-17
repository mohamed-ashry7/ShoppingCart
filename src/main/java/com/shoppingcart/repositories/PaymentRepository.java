package com.shoppingcart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
	

}
