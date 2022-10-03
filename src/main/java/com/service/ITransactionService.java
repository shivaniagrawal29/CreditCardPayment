package com.service;

import java.util.List;

import com.entity.Transaction;

public interface ITransactionService {

	public  Transaction addTransaction (Transaction transaction) ;
	
	public  Transaction removeTransaction  (long id)throws Throwable ;
	
	public Transaction updateTransaction (long id,Transaction transaction)throws Throwable;
	
	public List< Transaction>  getAllTransaction ();
	
	public Transaction getTransactionDetails(long id) throws Throwable ; 

}
