package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.NoRecordFoundException;
import com.advices.ResourceNotFoundException;
import com.entity.Customer;
import com.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer)throws Throwable {
		return customerRepo.save(customer);
	}

	
	@Override
	public Customer removeCustomer(String customerNumber) throws Throwable {
		Customer removedCust = customerRepo.findByCustomerNumber(customerNumber);
		if(removedCust==null){
            throw new ResourceNotFoundException("Customer doesn't exist in the database.");
        }
		customerRepo.delete(customerRepo.findByCustomerNumber(customerNumber));
		
		return removedCust;
	}

	
	@Override
	public Customer updateCustomer(String customerNumber, Customer customer) throws Throwable {
		Customer updateCust = customerRepo.findByCustomerNumber(customerNumber);
		
		if(updateCust==null){
            throw new ResourceNotFoundException("Customer doesn't exist in the database.");
        }
		
		updateCust.setAddresses(customer.getAddresses());
		updateCust.setContactNo(customer.getContactNo());
		updateCust.setDob(customer.getDob());
		updateCust.setEmail(customer.getEmail());
		updateCust.setName(customer.getName());
		
		customerRepo.save(updateCust);
		return updateCust;
	}

	
	@Override
	public Customer getCustomer(String customerNumber) throws Throwable {
		Customer c = customerRepo.findByCustomerNumber(customerNumber);
		if(c==null){
            throw new ResourceNotFoundException("Customer doesn't exist in the database.");
        }
		return c;
	}

	
	@Override
	public List<Customer> getAllCustomers()throws Throwable {
		List<Customer> customers = customerRepo.findAll();
		
		if(customers.isEmpty()){
			throw new NoRecordFoundException("NO Records found in database !!");
		}
		return customers;
	}
}
