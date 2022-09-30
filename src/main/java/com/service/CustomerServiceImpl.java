package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Customer;
import com.repository.ICustomerRepository;


public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepo;

	
	@Override
	public Customer addCustomer(Customer customer) {
		
		customerRepo.save(customer);
		
		return customer;
	}

	
	@Override
	public Customer removeCustomer(long custId) {
		
		Customer removedCust = customerRepo.findById(custId).orElseThrow();
		customerRepo.deleteById(custId);
		
		return removedCust;
	}

	
	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		
		Customer updateCust = customerRepo.findById(custId).orElseThrow();
		
		updateCust.setAddress(customer.getAddress());
		updateCust.setContactNo(customer.getContactNo());
		updateCust.setDob(customer.getDob());
		updateCust.setEmail(customer.getEmail());
		updateCust.setName(customer.getName());
		updateCust.setPassword(customer.getPassword());
		
		customerRepo.save(updateCust);
		
		return updateCust;
	}

	
	@Override
	public Customer getCustomer(long custId) {
		
		return customerRepo.findById(custId).orElseThrow();
		
	}

	
	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> listCust = customerRepo.findAll();
		return listCust;
		
	}
}
