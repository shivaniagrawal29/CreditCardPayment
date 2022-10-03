package com.service;

import com.entity.Payment;

public interface IPaymentService{
	public Payment addPayment(Payment payment);
	public Payment removePayment(long id)throws Throwable;
	public Payment updatePayment(long id, Payment payment)throws Throwable;
	public Payment getPayment(long id)throws Throwable;	
}
