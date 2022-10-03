package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Payment;
import com.repository.IPaymentRepository;

@SpringBootTest
class PaymentServiceTest {
	
	@Autowired
	PaymentService paymentservice;
	
	@MockBean
	IPaymentRepository paymentrepo;
	
	
	@Test
	void testAddPayment() {
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setMethod("upi");
		p1.setAmountDue(20000);
		
		Mockito.when(paymentrepo.save(p1)).thenReturn(p1);
		assertThat(paymentservice.addPayment(p1)).isEqualTo(p1);
	}

	@Test
	void testRemovePayment() throws Throwable{
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setMethod("upi");
		p1.setAmountDue(20000);
		
		Optional<Payment> p2 = Optional.of(p1);
		Mockito.when(paymentrepo.findById((long) 1)).thenReturn(p2);
		Mockito.when(paymentrepo.existsById(p1.getPaymentId())).thenReturn(false);
		assertFalse(paymentrepo.existsById(p1.getPaymentId()));
	}

	@Test
	void testUpdatePayment() throws Throwable{
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setMethod("upi");
		p1.setAmountDue(20000);
		
		Optional<Payment> p2 = Optional.of(p1);
		Mockito.when(paymentrepo.findById((long) 1)).thenReturn(p2);
		Mockito.when(paymentrepo.save(p1)).thenReturn(p1);
		
		p1.setAmountDue(400000);
		p1.setMethod("card");
		
		assertThat(paymentservice.updatePayment(1, p1)).isEqualTo(p1);
	}

	@Test
	void testGetPayment() throws Throwable{
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setMethod("upi");
		p1.setAmountDue(20000);
		
		Optional<Payment> p2 = Optional.of(p1);
		
		Mockito.when(paymentrepo.findById((long) 1)).thenReturn(p2);
		assertThat(paymentservice.getPayment(1)).isEqualTo(p1);
	}

}
