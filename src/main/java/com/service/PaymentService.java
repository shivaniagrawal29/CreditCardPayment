package com.service;

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
	public Payment removePayment(String paymentNumber) throws Throwable{
		Payment p1 = paymentrepo.findByPaymentNumber(paymentNumber);
		if(p1==null)
        {
            throw new ResourceNotFoundException("Payment not found !!");
        }
		paymentrepo.delete(paymentrepo.findByPaymentNumber(paymentNumber));
		return p1;
	}

	@Override
	public Payment updatePayment(String paymentNumber, Payment payment) throws Throwable{
		Payment p1 = paymentrepo.findByPaymentNumber(paymentNumber);
		if(p1==null)
        {
            throw new ResourceNotFoundException("Payment not found !!");
        }
		p1.setAmountDue(payment.getAmountDue());
		p1.setMethod(payment.getMethod());
		paymentrepo.save(p1);
		return p1;
	}

	@Override
	public Payment getPayment(String paymentNumber)throws Throwable {
		Payment p1 = paymentrepo.findByPaymentNumber(paymentNumber);
		if(p1==null)
        {
            throw new ResourceNotFoundException("Payment not found !!");
        }
		return p1;
	}
	
}
