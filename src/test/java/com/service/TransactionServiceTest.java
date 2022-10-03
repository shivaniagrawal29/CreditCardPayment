package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Transaction;
import com.repository.ITransactionRepository;
@SpringBootTest
class TransactionServiceTest {
	
	@Autowired
	TransactionService transactionservice;
	
	@MockBean
	ITransactionRepository transactionrepo;
	
	@Test
	void testAddTransaction() {
		Transaction t1 = new Transaction();
		t1.setTranId(1);
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setPaymentMethod("upi");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		t1.setAmount(34599);
		
		Mockito.when(transactionrepo.save(t1)).thenReturn(t1);
		assertThat(transactionservice.addTransaction(t1)).isEqualTo(t1);
	}

	@Test
	void testRemoveTransaction() throws Throwable {
		Transaction t1 = new Transaction();
		t1.setTranId(1);
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setPaymentMethod("upi");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		t1.setAmount(34599);
		
		Optional<Transaction> t2 = Optional.of(t1);
		Mockito.when(transactionrepo.findById((long) 1)).thenReturn(t2);
		Mockito.when(transactionrepo.existsById(t1.getTranId())).thenReturn(false);
		assertFalse(transactionrepo.existsById(t1.getTranId()));
	}

	@Test
	void testUpdateTransaction() throws Throwable {
		Transaction t1 = new Transaction();
		t1.setTranId(1);
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setPaymentMethod("upi");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		t1.setAmount(34599);
		
		Optional<Transaction> t2 = Optional.of(t1);
		Mockito.when(transactionrepo.findById((long) 1)).thenReturn(t2);
		Mockito.when(transactionrepo.save(t1)).thenReturn(t1);
		
		t1.setTranDate(LocalDate.of(2016, 8, 23));
		t1.setStatus("Unpaid");
		t1.setPaymentMethod("cash");
		t1.setDescription("Payment not successful");
		t1.setCardNumber("1232565");
		t1.setAmount(3499);
		
		assertThat(transactionservice.updateTransaction(1, t1)).isEqualTo(t1);
	}
	
	@Test
	void testGetTransactionDetails() throws Throwable {
		Transaction t1 = new Transaction();
		t1.setTranId(1);
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setPaymentMethod("upi");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		t1.setAmount(34599);
		
		Optional<Transaction> t2 = Optional.of(t1);
		
		Mockito.when(transactionrepo.findById((long) 1)).thenReturn(t2);
		assertThat(transactionservice.getTransactionDetails(1)).isEqualTo(t1);
		
	}

	@Test
	void testGetAllTransaction() {
		Transaction t1 = new Transaction();
		t1.setTranId(1);
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setPaymentMethod("upi");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		t1.setAmount(34599);
		
		Transaction t2 = new Transaction();
		t2.setTranId(2);
		t2.setTranDate(LocalDate.of(2013, 9, 23));
		t2.setStatus("Paid");
		t2.setPaymentMethod("upi");
		t2.setDescription("Payment successful");
		t2.setCardNumber("14565");
		t2.setAmount(345);
		
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(t1);
		transactions.add(t2);
		
		Mockito.when(transactionrepo.findAll()).thenReturn(transactions);
		assertThat(transactionservice.getAllTransaction()).isEqualTo(transactions);
	}

}
