package com.service;

import java.util.List;

import com.entity.Customer;

public interface ICustomerService {
	
	Customer addCustomer(Customer customer);
	
	Customer removeCustomer(long customerId);
	
	Customer updateCustomer(long customerId, Customer customer);
	
	Customer getCustomer(long customerId);
	
	List<Customer> getAllCustomers();

}
