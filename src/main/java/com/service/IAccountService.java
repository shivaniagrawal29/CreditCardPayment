package com.service;

import java.util.List;

import com.entity.Account;

public interface IAccountService {

	Account addAccount(Account account);
	
	Account removeAccount(long id) throws Throwable;
	
	Account updateAccount(long id, Account account) throws Throwable;
	
	Account getAccount(long id) throws Throwable;
	
	List<Account> getAllAccounts();
}
