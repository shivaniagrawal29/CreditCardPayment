package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Account;
import com.repository.IAccountRepository;

public class AccountService implements IAccountService {

	@Autowired
	IAccountRepository accountRepo;
	
	@Override
	public Account addAccount(Account account) {
		accountRepo.save(account);
		return account;
	}

	@Override
	public Account removeAccount(long id) {
		Account removedAccount = accountRepo.findById(id).orElseThrow();
		accountRepo.deleteById(id);
		return removedAccount;
	}

	@Override
	public Account updateAccount(long id, Account account) {
		Account originalAccount = accountRepo.findById(id).orElseThrow();
		
		originalAccount.setAccountName(account.getAccountName());
		originalAccount.setAccountType(account.getAccountType());
		originalAccount.setBalance(account.getBalance());
		
		return originalAccount;
	}

	@Override
	public Account getAccount(long id) {
		return accountRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

}
