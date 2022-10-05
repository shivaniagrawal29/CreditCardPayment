package com.service;

import java.util.List;

import com.entity.Customer;

public interface ICustomerService {
	
	Customer addCustomer(Customer customer)throws Throwable;
	
	Customer removeCustomer(long customerId) throws Throwable;
	
	Customer updateCustomer(long customerId, Customer customer) throws Throwable;
	
	Customer getCustomer(long customerId) throws Throwable;
	
	List<Customer> getAllCustomers()throws Throwable;

}
