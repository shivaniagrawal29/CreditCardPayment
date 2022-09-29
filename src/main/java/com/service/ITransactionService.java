package com.service;

import java.util.List;

import com.entity.Transaction;

public interface ITransactionService {

public  Transaction addTransaction (Transaction transaction) ;
	
	public  Transaction removeTransaction  (long id) ;
	
	public Transaction updateTransaction (long id,Transaction transaction);
	
	public List< Transaction>  getAllTransaction ();

}
