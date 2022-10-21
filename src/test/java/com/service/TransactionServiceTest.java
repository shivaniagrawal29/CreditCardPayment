package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		t1.setTranNumber("1234");
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		
		Mockito.when(transactionrepo.save(t1)).thenReturn(t1);
		assertThat(transactionservice.addTransaction(t1)).isEqualTo(t1);
	}

	@Test
	void testRemoveTransaction() {
		Transaction t1 = new Transaction();
		t1.setTranNumber("1234");
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		
		Transaction t2 = t1;
		Mockito.when(transactionrepo.findByTranNumber("1234")).thenReturn(t2);
		Mockito.when(transactionrepo.existsByTranNumber(t1.getTranNumber())).thenReturn(false);
		assertFalse(transactionrepo.existsByTranNumber(t1.getTranNumber()));
	}

	@Test
	void testUpdateTransaction() throws Throwable {
		Transaction t1 = new Transaction();
		t1.setTranNumber("1234");
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		
		Transaction t2 = t1;
		Mockito.when(transactionrepo.findByTranNumber("1234")).thenReturn(t2);
		Mockito.when(transactionrepo.save(t1)).thenReturn(t1);
		
		t1.setTranDate(LocalDate.of(2016, 8, 23));
		t1.setStatus("Unpaid");
		t1.setDescription("Payment not successful");
		t1.setCardNumber("1232565");
		
		assertThat(transactionservice.updateTransaction("1234", t1)).isEqualTo(t1);
	}
	
	@Test
	void testGetTransactionDetails() throws Throwable {
		Transaction t1 = new Transaction();
		t1.setTranNumber("1234");
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		
		Transaction t2 = t1;
		
		Mockito.when(transactionrepo.findByTranNumber("1234")).thenReturn(t2);
		assertThat(transactionservice.getTransactionDetails("1234")).isEqualTo(t1);
		
	}

	@Test
	void testGetAllTransaction() throws Throwable{
		Transaction t1 = new Transaction();
		t1.setTranNumber("1234");
		t1.setTranDate(LocalDate.of(2016, 9, 23));
		t1.setStatus("Paid");
		t1.setDescription("Payment successful");
		t1.setCardNumber("1234565");
		
		Transaction t2 = new Transaction();
		t2.setTranNumber("5678");
		t2.setTranDate(LocalDate.of(2013, 9, 23));
		t2.setStatus("Paid");
		t2.setDescription("Payment successful");
		t2.setCardNumber("14565");
		
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(t1);
		transactions.add(t2);
		
		Mockito.when(transactionrepo.findAll()).thenReturn(transactions);
		assertThat(transactionservice.getAllTransaction()).isEqualTo(transactions);
	}

}
