package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Transaction;
import com.repository.ITransactionRepository;

@Service
public class ITransactionServiceImpl implements ITransactionService{

	@Autowired
	ITransactionRepository transrepoo; 
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		Transaction transaction1=transrepoo.save(transaction);
		return transaction1;
		
	}

	@Override
	public Transaction removeTransaction(long id) {
	     
	   Transaction transaction= transrepoo.findById(id).orElseThrow();
		transrepoo.deleteById(id);
		return transaction;
	}

	@Override
	public Transaction updateTransaction(long id, Transaction transaction) {
	
		Transaction transaction1=transrepoo.findById(id).orElseThrow() ;
		transaction1.setStatus(transaction.getStatus());
		transaction1.setTranDate(transaction.getTranDate());
		transrepoo.save(transaction1);
		
		return transaction1;
	}

	@Override
	
	public List<Transaction> getAllTransaction() {
		List<Transaction>transactions=transrepoo.findAll();
		return transactions;
	}

}
