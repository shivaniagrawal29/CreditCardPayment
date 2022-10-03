package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	PaymentService paymentservice;
	
	@PostMapping("/addpayment")
	public Payment addPayment(@Valid@RequestBody Payment payment)
	{
		Payment p1 = paymentservice.addPayment(payment);
		return p1;
	}
	
	@DeleteMapping("/removepayment/{id}")
	public Payment removePayment(@PathVariable long id)throws Throwable
	{
		Payment p1 = paymentservice.removePayment(id);
		return p1;
	}
	
	@PutMapping("/updatepayment/{id}")
	public Payment updatePayment(@PathVariable long id,@Valid@RequestBody Payment payment)throws Throwable
	{
		Payment p = paymentservice.updatePayment(id, payment);
		return p;
	}
	
	@GetMapping("/getpayment/{id}")
	public Payment getPayment(@PathVariable long id)throws Throwable
	{
		Payment p = paymentservice.getPayment(id);
		return p;
	}
}
