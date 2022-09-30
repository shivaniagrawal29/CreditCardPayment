package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Customer;

@Service
public interface ICustomerService {
	
	Customer addCustomer(Customer customer);
	
	Customer removeCustomer(long customerId);
	
	Customer updateCustomer(long customerId, Customer customer);
	
	Customer getCustomer(long customerId);
	
	List<Customer> getAllCustomers();

}
