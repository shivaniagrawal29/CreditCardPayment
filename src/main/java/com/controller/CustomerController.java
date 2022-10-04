package com.controller;

import java.util.List;



import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	Log logger = LogFactory.getLog(CustomerController.class);
	
   @Autowired
    CustomerService csi;
    
    @PostMapping("/addcustomer")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer)
    {
        Customer customer1 = csi.addCustomer(customer);
        logger.info("addCustomer successful.");
        ResponseEntity re=new ResponseEntity<String>("Added Customer Sucessfully !",HttpStatus.OK);
        return re;
    }
    
    @DeleteMapping("/removecustomer/{customerid}")
    public ResponseEntity<String> removeCustomer(@PathVariable long customerid) throws Throwable
    {
        Customer customer2 = csi.removeCustomer(customerid);
        logger.info("removeCustomer successful.");
        ResponseEntity re = new ResponseEntity<String>("Removed Customer Sucessfully !",HttpStatus.OK);
        return re;
    }
    
    @PutMapping("/updatecustomer/{customerid}")
    public ResponseEntity<String> updateCustomer(@Valid @PathVariable long customerid, @RequestBody Customer customer) throws Throwable
    {
        Customer customer3 = csi.updateCustomer(customerid, customer);
        logger.info("updateCustomer successful.");
        ResponseEntity re = new ResponseEntity<String>("Updated Customer Successfully !", HttpStatus.OK);
        return re;
    }
    
    @GetMapping("/getcustomer/{custid}")
    public Customer getCustomer(@PathVariable long customerid) throws Throwable
    {
        Customer customer4 = csi.getCustomer(customerid);
        logger.info("getCustomer successful.");
        return customer4;
    }
    
    @GetMapping("/getallcustomers")
    public List<Customer> getCustomer(){
        List<Customer> custLst= csi.getAllCustomers();
        logger.info("getallcustomers successful.");
        return custLst;
    }
}