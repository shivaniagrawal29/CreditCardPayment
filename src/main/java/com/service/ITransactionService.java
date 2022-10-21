package com.service;

import java.util.List;

import com.entity.Transaction;

public interface ITransactionService {

	public  Transaction addTransaction (Transaction transaction) ;
	
	public  Transaction removeTransaction  (String tranNumber)throws Throwable ;
	
	public Transaction updateTransaction (String tranNumber,Transaction transaction)throws Throwable;
	
	public List< Transaction>  getAllTransaction () throws  Throwable;
	
	public Transaction getTransactionDetails(String tranNumber) throws Throwable ; 

}
