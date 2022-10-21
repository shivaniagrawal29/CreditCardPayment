package com.service;

import java.util.List;

import com.entity.Account;

public interface IAccountService {

	Account addAccount(Account account)throws Throwable;
	
	Account removeAccount(String accountNumber) throws Throwable;
	
	Account updateAccount(String accountNumber, Account account) throws Throwable;
	
	Account getAccount(String accountNumber) throws Throwable;
	
	List<Account> getAllAccounts()throws Throwable;
}
