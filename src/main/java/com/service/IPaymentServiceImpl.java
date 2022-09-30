package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Payment;
import com.repository.IPaymentRepository;

@Service
public class IPaymentServiceImpl implements IPaymentService{
	
	@Autowired
	IPaymentRepository paymentrepo;

	@Override
	public Payment addPayment(Payment payment) {
		Payment p = paymentrepo.save(payment);
		return p;
	}

	@Override
	public Payment removePayment(long id) {
		Payment p1 = paymentrepo.findById(id).orElseThrow();
		paymentrepo.deleteById(id);
		return p1;
	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		Payment p1 = paymentrepo.findById(id).orElseThrow();
		p1.setAmountDue(payment.getAmountDue());
		p1.setMethod(payment.getMethod());
		paymentrepo.save(p1);
		return p1;
	}

	@Override
	public Payment getPayment(long id) {
		Payment p1 = paymentrepo.findById(id).orElseThrow();
		return p1;
	}
	
}
