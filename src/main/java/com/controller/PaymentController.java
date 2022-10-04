package com.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	Log logger = LogFactory.getLog(PaymentController.class);
	
	@Autowired
	PaymentService paymentservice;
	
	@PostMapping("/addpayment")
	public ResponseEntity<String> addPayment(@Valid@RequestBody Payment payment)
	{
		paymentservice.addPayment(payment);
		logger.info("addPayment successful.");
		return ResponseEntity.ok("Payment added successfully in the database!");
	}
	
	@DeleteMapping("/removepayment/{id}")
	public ResponseEntity<String> removePayment(@PathVariable long id)throws Throwable
	{
		paymentservice.removePayment(id);
		logger.info("removePayment successful.");
		return ResponseEntity.ok("Payment removed successfully in the database!");
	}
	
	@PutMapping("/updatepayment/{id}")
	public ResponseEntity<String> updatePayment(@PathVariable long id,@Valid@RequestBody Payment payment)throws Throwable
	{
		paymentservice.updatePayment(id, payment);
		logger.info("updatePayment successful.");
		return ResponseEntity.ok("Payment removed successfully from the database!");
	}
	
	@GetMapping("/getpayment/{id}")
	public Payment getPayment(@PathVariable long id)throws Throwable
	{
		Payment p = paymentservice.getPayment(id);
		logger.info("getPayment successful.");
		return p;
	}
}
