package com.service;

import java.util.List;

import com.entity.Customer;

public interface ICustomerService {
	
	Customer addCustomer(Customer customer)throws Throwable;
	
	Customer removeCustomer(String customerNumber) throws Throwable;
	
	Customer updateCustomer(String customerNumber, Customer customer) throws Throwable;
	
	Customer getCustomer(String customerNumber) throws Throwable;
	
	List<Customer> getAllCustomers()throws Throwable;

}
