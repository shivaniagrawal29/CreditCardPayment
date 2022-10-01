package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping("/home")
public class CustomerController {

	@Autowired
	CustomerService csi;
	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		Customer customer1 = csi.addCustomer(customer);
		return customer1;
	}
	
	@DeleteMapping("/removecustomer/{customerid}")
	public Customer removeCustomer(@PathVariable long customerid)
	{
		Customer customer2 = csi.removeCustomer(customerid);
		return customer2;
	}
	
	@PutMapping("/updatecustomer/{customerid}")
	public Customer updateCustomer(@PathVariable long customerid, @RequestBody Customer customer)
	{
		Customer customer3 = csi.updateCustomer(customerid, customer);
		return customer3;
	}
	
	@GetMapping("/getcustomer/{custid}")
	public Customer getCustomer(@PathVariable long customerid) 
	{
		Customer customer4 = csi.getCustomer(customerid);
		return customer4;
	}
	
	@GetMapping("/getallcustomers")
	public List<Customer> getCustomer(){
		List<Customer> custLst= csi.getAllCustomers();
		return custLst;
	}
}
