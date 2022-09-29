package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Account;

@Service
public interface IAccountService {

	Account addAccount(Account account);
	
	Account removeAccount(long id);
	
	Account updateAccount(long id, Account account);
	
	Account getAccount(long id);
	
	List<Account> getAllAccounts();
}
