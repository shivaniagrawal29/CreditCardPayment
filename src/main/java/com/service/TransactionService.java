package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.NoRecordFoundException;
import com.advices.ResourceNotFoundException;
import com.entity.Transaction;
import com.repository.ITransactionRepository;

@Service
@SuppressWarnings(value = { "rawtypes", "unchecked" })
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
	public Transaction updateTransaction(long id, Transaction transaction) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Transaction not found !!");
		Transaction transaction1=transrepoo.findById(id).orElseThrow(s1) ;
		transaction1.setStatus(transaction.getStatus());
		transaction1.setTranDate(transaction.getTranDate());
		transrepoo.save(transaction1);
		
		return transaction1;
	}

	@Override
	public List<Transaction> getAllTransaction() throws Throwable  {
		List<Transaction>transactions=transrepoo.findAll();
		if(transactions.isEmpty())
		{	throw new NoRecordFoundException("NO Records found in database !!");
		}
		 
		return transactions;
	}

	@Override
	public Transaction getTransactionDetails(long id) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Transaction doesn't exist in the database.");
		Transaction t = transrepoo.findById(id).orElseThrow(s);
		return t;
	}

}
