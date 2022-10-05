package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IdAlreadyExistsException;
import com.advices.NoRecordFoundException;
import com.advices.ResourceNotFoundException;
import com.entity.Customer;
import com.repository.ICustomerRepository;

@Service
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class CustomerService implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer)throws Throwable {
	
		if( !customerRepo.findById(customer.getCustomerId()).isEmpty()  )
		{
			throw new IdAlreadyExistsException("Customer already exists in database !!");
		}
		customerRepo.save(customer);		
		return customer;
	}

	
	@Override
	public Customer removeCustomer(long custId) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Customer doesn't exist in the database.");
		Customer removedCust = customerRepo.findById(custId).orElseThrow(s);
		customerRepo.deleteById(custId);
		
		return removedCust;
	}

	
	@Override
	public Customer updateCustomer(long custId, Customer customer) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Customer doesn't exist in the database.");
		Customer updateCust = customerRepo.findById(custId).orElseThrow(s);
		
		updateCust.setAddresses(customer.getAddresses());
		updateCust.setContactNo(customer.getContactNo());
		updateCust.setDob(customer.getDob());
		updateCust.setEmail(customer.getEmail());
		updateCust.setName(customer.getName());
		
		customerRepo.save(updateCust);
		return updateCust;
	}

	
	@Override
	public Customer getCustomer(long custId) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Customer doesn't exist in the database.");
		return customerRepo.findById(custId).orElseThrow(s);
	}

	
	@Override
	public List<Customer> getAllCustomers()throws Throwable {
		List<Customer> customers = customerRepo.findAll();
		
		if(customers.isEmpty())
		{	throw new NoRecordFoundException("NO Records found in database !!");
		}
		return customers;
	}
}
