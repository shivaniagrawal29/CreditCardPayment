package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
    void testAddAccount() throws Throwable{
        Account a1 = new Account();
        a1.setAccountNumber("123456");
        a1.setAccountName("abcd");
        a1.setAccountType("Salary");
        a1.setBalance(123000);
        
        Mockito.when(accountrepo.save(a1)).thenReturn(a1);
        assertThat(accountservice.addAccount(a1)).isEqualTo(a1);
    }

   @Test
    void testRemoveAccount() {
        Account a1 = new Account();
        a1.setAccountNumber("123456");
        a1.setAccountName("abcd");
        a1.setAccountType("Salary");
        a1.setBalance(123000);
        
        Account a2 = a1;
        Mockito.when(accountrepo.findByAccountNumber("123456")).thenReturn(a2);
        Mockito.when(accountrepo.existsByAccountNumber(a1.getAccountNumber())).thenReturn(false);
        assertFalse(accountrepo.existsByAccountNumber(a1.getAccountNumber()));
    }

   @Test
    void testUpdateAccount() throws Throwable {
        Account a1 = new Account();
        a1.setAccountNumber("123456");
        a1.setAccountName("abcd");
        a1.setAccountType("Salary");
        a1.setBalance(123000);
        
        Account a2 = a1;
        Mockito.when(accountrepo.findByAccountNumber("123456")).thenReturn(a2);
        Mockito.when(accountrepo.save(a1)).thenReturn(a1);
        
        a1.setAccountNumber("123456");
        a1.setAccountName("xyz");
        a1.setAccountType("Salary");
        a1.setBalance(12302);
        
        assertThat(accountservice.updateAccount("123456", a1)).isEqualTo(a1);
    }

   @Test
    void testGetAccount() throws Throwable {
        Account a1 = new Account();
        a1.setAccountNumber("123456");
        a1.setAccountName("abcd");
        a1.setAccountType("Salary");
        a1.setBalance(123000);
        
        Account a2 = a1;
        Mockito.when(accountrepo.findByAccountNumber("123456")).thenReturn(a2);
        assertThat(accountservice.getAccount("123456")).isEqualTo(a1);
    }

   @Test
    void testGetAllAccounts() throws Throwable{
        Account a1 = new Account();
        a1.setAccountNumber("123456");
        a1.setAccountName("abcd");
        a1.setAccountType("Salary");
        a1.setBalance(123000);
        
        Account a2 = new Account();
        a2.setAccountName("xyz");
        a1.setAccountNumber("123453");
        a2.setAccountType("Salary");
        a2.setBalance(1230);
        
        List<Account> accounts = new ArrayList<>();
        accounts.add(a1);
        accounts.add(a2);
        
        Mockito.when(accountrepo.findAll()).thenReturn(accounts);
        assertThat(accountservice.getAllAccounts()).isEqualTo(accounts);
    }

}
