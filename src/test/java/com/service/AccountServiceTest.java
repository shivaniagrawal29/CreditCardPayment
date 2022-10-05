package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Account;
import com.repository.IAccountRepository;

@SpringBootTest
class AccountServiceTest {
	
	@Autowired
	AccountService accountservice;
	
	@MockBean
	IAccountRepository accountrepo;
	
	
	@Test
	void testAddAccount()throws Throwable {
		Account a1 = new Account();
		a1.setAccountId(12345);
		a1.setAccountName("abcd");
		a1.setAccountType("Salary");
		a1.setBalance(123000);
		
		
		Mockito.when(accountrepo.save(a1)).thenReturn(a1);
		assertThat(accountservice.addAccount(a1)).isEqualTo(a1);
	}

	@Test
	void testRemoveAccount() {
		Account a1 = new Account();
		a1.setAccountId(12345);
		a1.setAccountName("abcd");
		a1.setAccountType("Salary");
		a1.setBalance(123000);
		
		Optional<Account> a2 = Optional.of(a1);
		Mockito.when(accountrepo.findById((long) 1)).thenReturn(a2);
		Mockito.when(accountrepo.existsById(a1.getAccountId())).thenReturn(false);
		assertFalse(accountrepo.existsById(a1.getAccountId()));
	}

	@Test
	void testUpdateAccount() throws Throwable {
		Account a1 = new Account();
		a1.setAccountId(12345);
		a1.setAccountName("abcd");
		a1.setAccountType("Salary");
		a1.setBalance(123000);
		
		Optional<Account> a2 = Optional.of(a1);
		Mockito.when(accountrepo.findById((long) 1)).thenReturn(a2);
		Mockito.when(accountrepo.save(a1)).thenReturn(a1);
		
		a1.setAccountId(12535);
		a1.setAccountName("xyz");
		a1.setAccountType("Salary");
		a1.setBalance(12302);
		
		assertThat(accountservice.updateAccount(1, a1)).isEqualTo(a1);
	}

	@Test
	void testGetAccount() throws Throwable {
		Account a1 = new Account();
		a1.setAccountId(12345);
		a1.setAccountName("abcd");
		a1.setAccountType("Salary");
		a1.setBalance(123000);
		
		Optional<Account> a2 = Optional.of(a1);
		Mockito.when(accountrepo.findById((long) 1)).thenReturn(a2);
		assertThat(accountservice.getAccount(1)).isEqualTo(a1);
	}

	@Test
	void testGetAllAccounts()throws Throwable {
		Account a1 = new Account();
		a1.setAccountId(12345);
		a1.setAccountName("abcd");
		a1.setAccountType("Salary");
		a1.setBalance(123000);
		
		Account a2 = new Account();
		a2.setAccountId(12735);
		a2.setAccountName("xyz");
		a2.setAccountType("Salary");
		a2.setBalance(1230);
		
		List<Account> accounts = new ArrayList<>();
		accounts.add(a1);
		accounts.add(a2);
		
		Mockito.when(accountrepo.findAll()).thenReturn(accounts);
		assertThat(accountservice.getAllAccounts()).isEqualTo(accounts);
	}

}
