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
import com.service.CustomerServiceImpl;

@RestController
@RequestMapping("/home")
public class CustomerController {

	@Autowired
	CustomerServiceImpl csi;
	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer cust)
	{
		Customer cust1 = csi.addCustomer(cust);
		return cust1;
	}
	
	@DeleteMapping("/removecustomer/{custid}")
	public Customer removeCustomer(@PathVariable Long custid)
	{
		Customer cust2 = csi.removeCustomer(custid);
		return cust2;
	}
	
	@PutMapping("/updatecustomer/{custid}")
	public Customer updateCustomer(@PathVariable Long custid, @RequestBody Customer cust)
	{
		Customer cust3 = csi.updateCustomer(custid, cust);
		return cust3;
	}
	
	@GetMapping("/getcustomer/{custid}")
	public Customer getCustomer(@PathVariable Long custid) 
	{
		Customer cust4 = csi.getCustomer(custid);
		return cust4;
	}
	
	@GetMapping("/getallcustomers")
	public List<Customer> getCustomer(){
		List<Customer> custLst= csi.getAllCustomers();
		return custLst;
	}
}
