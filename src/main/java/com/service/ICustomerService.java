package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Customer;

@Service
public interface ICustomerService {
	
	Customer addCustomer(Customer customer);
	
	Customer removeCustomer(long custId);
	
	Customer updateCustomer(long custId, Customer customer);
	
	Customer getCustomer(long custId);
	
	List<Customer> getAllCustomers();

}
