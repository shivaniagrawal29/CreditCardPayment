package com.controller;

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

import com.entity.Payment;

import com.service.PaymentService;

@RestController
@RequestMapping("home")
public class PaymentController {
	
	Log logger = LogFactory.getLog(AccountController.class);
	
	@Autowired
	PaymentService paymentservice;
	
	@PostMapping("/addpayment")
	public ResponseEntity<String> addPayment(@Valid@RequestBody Payment payment)
	{
		Payment payment1 = paymentservice.addPayment(payment);
		ResponseEntity re=new ResponseEntity<String>("Payment details added Successfully !!",HttpStatus.OK);
		logger.info("addPayment Successful !!");
		return re;
		//return payment1;
	}
	
	@DeleteMapping("/removepayment/{id}")
	public ResponseEntity<String> removePayment(@PathVariable long id)throws Throwable
	{
		Payment payment = paymentservice.removePayment(id);
		ResponseEntity re=new ResponseEntity<String>("Payment details added Successfully !!",HttpStatus.OK);
		logger.info("removePayment Successful !!");
		return re;
		//return payment;
	}
	
	@PutMapping("/updatepayment/{id}")
	public ResponseEntity<String> updatePayment(@PathVariable long id,@Valid@RequestBody Payment payment)throws Throwable
	{
		Payment payment1 = paymentservice.updatePayment(id, payment);
		ResponseEntity re=new ResponseEntity<String>("Payment details added Successfully !!",HttpStatus.OK);
		logger.info("updatePayment Successful !!");
		return re;
		//return payment;
	}
	
	@GetMapping("/getpayment/{id}")
	public ResponseEntity<String> getPayment(@PathVariable long id)throws Throwable
	{
		Payment payment = paymentservice.getPayment(id);
		ResponseEntity re=new ResponseEntity<String>("Payment details added Successfully !!",HttpStatus.OK);
		logger.info("getPayment Successful !!");
		return re;
		//return payment;
	}
}
