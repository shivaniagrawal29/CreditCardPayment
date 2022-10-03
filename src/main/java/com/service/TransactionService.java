package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Transaction;
import com.repository.ITransactionRepository;

@Service
public class TransactionService implements ITransactionService{

	@Autowired
	ITransactionRepository transrepoo; 
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		Transaction transaction1=transrepoo.save(transaction);
		return transaction1;
		
	}

	@Override
	public Transaction removeTransaction(long id) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Transaction not found !!");
	   Transaction transaction= transrepoo.findById(id).orElseThrow(s1);
		transrepoo.deleteById(id);
		return transaction;
	}

	@Override
	public Transaction updateTransaction(long id, Transaction transaction)throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Transaction not found !!");
		Transaction transaction1=transrepoo.findById(id).orElseThrow(s1) ;
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
