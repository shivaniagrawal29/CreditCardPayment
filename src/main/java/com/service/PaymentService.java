package com.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Payment;
import com.repository.IPaymentRepository;

@Service
public class PaymentService implements IPaymentService{
	
	@Autowired
	IPaymentRepository paymentrepo;

	@Override
	public Payment addPayment(Payment payment) {
		Payment p = paymentrepo.save(payment);
		return p;
	}

	@Override
	public Payment removePayment(long id) throws Throwable{
		Supplier s1= ()->new ResourceNotFoundException("Payment not found !!");
		Payment p1 = paymentrepo.findById(id).orElseThrow(s1);
		paymentrepo.deleteById(id);
		return p1;
	}

	@Override
	public Payment updatePayment(long id, Payment payment) throws Throwable{
		Supplier s1= ()->new ResourceNotFoundException("Payment not found !!");
		Payment p1 = paymentrepo.findById(id).orElseThrow(s1);
		p1.setAmountDue(payment.getAmountDue());
		p1.setMethod(payment.getMethod());
		paymentrepo.save(p1);
		return p1;
	}

	@Override
	public Payment getPayment(long id)throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Payment not found !!");
		Payment p1 = paymentrepo.findById(id).orElseThrow(s1);
		return p1;
	}
	
}
