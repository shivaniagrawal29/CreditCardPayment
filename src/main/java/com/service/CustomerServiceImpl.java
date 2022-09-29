package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Customer;
import com.repository.ICustomerRepository;


public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository custRepo;

	
	@Override
	public Customer addcustomer(Customer customer) {
		
		custRepo.save(customer);
		
		return customer;
	}

	
	@Override
	public Customer removeCustomer(long custId) {
		
		Customer removedCust = custRepo.findById(custId).orElseThrow();
		custRepo.deleteById(custId);
		
		return removedCust;
	}

	
	@Override
	public Customer updateCustomer(long custId, Customer customer) {
		
		Customer updateCust = custRepo.findById(custId).orElseThrow();
		
		updateCust.setAddress(customer.getAddress());
		updateCust.setContactNo(customer.getContactNo());
		updateCust.setDob(customer.getDob());
		updateCust.setEmail(customer.getEmail());
		updateCust.setName(customer.getName());
		updateCust.setPassword(customer.getPassword());
		
		custRepo.save(updateCust);
		
		return updateCust;
	}

	
	@Override
	public Customer getCustomer(long custId) {
		
		return custRepo.findById(custId).orElseThrow();
		
	}

	
	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> listCust = custRepo.findAll();
		return listCust;
		
	}
}
