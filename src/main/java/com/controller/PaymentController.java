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
	
	@DeleteMapping("/removepayment/{paymentNumber}")
	public ResponseEntity<String> removePayment(@PathVariable String paymentNumber)throws Throwable
	{
		paymentservice.removePayment(paymentNumber);
		logger.info("removePayment successful.");
		return ResponseEntity.ok("Payment removed successfully in the database!");
	}
	
	@PutMapping("/updatepayment/{paymentNumber}")
	public ResponseEntity<String> updatePayment(@PathVariable String paymentNumber,@Valid@RequestBody Payment payment)throws Throwable
	{
		paymentservice.updatePayment(paymentNumber, payment);
		logger.info("updatePayment successful.");
		return ResponseEntity.ok("Payment removed successfully from the database!");
	}
	
	@GetMapping("/getpayment/{paymentNumber}")
	public Payment getPayment(@PathVariable String paymentNumber)throws Throwable
	{
		Payment p = paymentservice.getPayment(paymentNumber);
		logger.info("getPayment successful.");
		//return ResponseEntity.ok("Payment removed successfully from the database!");

		return p;
	}
}
