package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.NoRecordFoundException;
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
	public Transaction removeTransaction(String tranNumber) throws Throwable {
	   Transaction transaction= transrepoo.findByTranNumber(tranNumber);
	   
	   if(transaction==null)
       {
           throw new ResourceNotFoundException("Transaction not found !!");
       }
	   
		transrepoo.delete(transrepoo.findByTranNumber(tranNumber));
		return transaction;
	}

	@Override
	public Transaction updateTransaction(String tranNumber, Transaction transaction) throws Throwable {
		Transaction transaction1=transrepoo.findByTranNumber(tranNumber);
		if(transaction==null){
	       throw new ResourceNotFoundException("Transaction not found !!");
	    }
		
		transaction1.setStatus(transaction.getStatus());
		transaction1.setTranDate(transaction.getTranDate());
		
		transrepoo.save(transaction1);
		return transaction1;
	}

	@Override
	public List<Transaction> getAllTransaction() throws Throwable  {
		List<Transaction> transactions=transrepoo.findAll();
		if(transactions.isEmpty()){	
			throw new NoRecordFoundException("NO Records found in database !!");
		}
		 
		return transactions;
	}

	@Override
	public Transaction getTransactionDetails(String tranNumber) throws Throwable {
		Transaction t = transrepoo.findByTranNumber(tranNumber);
		if(t == null){	
			throw new NoRecordFoundException("Transaction doesn't exist in the database.");
		}
		
		return t;
	}

}
