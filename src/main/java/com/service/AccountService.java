package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Account;
import com.repository.IAccountRepository;

@Service
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class AccountService implements IAccountService {

	@Autowired
	IAccountRepository accountRepo;
	
	@Override
	public Account addAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account removeAccount(long id) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Account doesn't exist in the database.");
		Account removedAccount = accountRepo.findById(id).orElseThrow(s);
		accountRepo.deleteById(id);
		return removedAccount;
	}

	@Override
	public Account updateAccount(long id, Account account) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Account doesn't exist in the database.");
		Account originalAccount = accountRepo.findById(id).orElseThrow(s);
		
		originalAccount.setAccountName(account.getAccountName());
		originalAccount.setAccountType(account.getAccountType());
		originalAccount.setBalance(account.getBalance());
		
		accountRepo.save(originalAccount);
		return originalAccount;
	}

	@Override
	public Account getAccount(long id) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Account doesn't exist in the database.");
		return accountRepo.findById(id).orElseThrow(s);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

}
