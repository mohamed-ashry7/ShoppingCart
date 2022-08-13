package com.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.shoppingcart.models.Customer;
import com.shoppingcart.models.Product;

@SpringBootApplication
public class ShoppingCartApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}


	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.exposeIdsFor(Product.class);
		config.exposeIdsFor(Customer.class);
	}

}
