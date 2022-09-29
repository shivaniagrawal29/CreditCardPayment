package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CreditCardPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardPaymentApplication.class, args);
		System.out.println("Connected to database....");
	}

}
