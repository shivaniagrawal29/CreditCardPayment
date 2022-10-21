package com.service;

import com.entity.Payment;

public interface IPaymentService{
	public Payment addPayment(Payment payment);
	public Payment removePayment(String paymentNumber)throws Throwable;
	public Payment updatePayment(String paymentNumber, Payment payment)throws Throwable;
	public Payment getPayment(String paymentNumber)throws Throwable;	
}
