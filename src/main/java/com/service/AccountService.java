package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.NoRecordFoundException;
import com.advices.ResourceNotFoundException;
import com.entity.Account;
import com.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	IAccountRepository accountRepo;
	
	@Override
	public Account addAccount(Account account) throws Throwable {
		return accountRepo.save(account);
	}

	@Override
	public Account removeAccount(String accountNumber) throws Throwable {
		Account a = accountRepo.getAccountByAccountNumber(accountNumber);
        if(a==null)
        {
            throw new ResourceNotFoundException("Account doesn't exist in the database.");
        }
        
        accountRepo.delete(accountRepo.getAccountByAccountNumber(accountNumber));
        return a;
	}

	@Override
	public Account updateAccount(String accountNumber, Account account) throws Throwable {
		Account originalAccount = accountRepo.findByAccountNumber(accountNumber);
        
        if(originalAccount==null){
            throw new ResourceNotFoundException("Account doesn't exist in the database.");
        }
        
        originalAccount.setAccountName(account.getAccountName());
        originalAccount.setAccountType(account.getAccountType());
        originalAccount.setBalance(account.getBalance());
        
        accountRepo.save(originalAccount);
        return originalAccount;
	}

	@Override
	public Account getAccount(String accountNumber) throws Throwable {
		Account a = accountRepo.findByAccountNumber(accountNumber);
        if(a==null){
            throw new ResourceNotFoundException("Account doesn't exist in the database.");
        }
        return a;
	}

	@Override
	public List<Account> getAllAccounts() throws Throwable{
	
		List<Account>accounts=accountRepo.findAll();
        if(accounts.isEmpty()){    
        	throw new NoRecordFoundException("NO Records found in database !!");
        }
        return accounts;
	}

}
