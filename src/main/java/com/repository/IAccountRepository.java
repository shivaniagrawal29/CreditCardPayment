package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByAccountNumber(String accountNumber);
	public Account getAccountByAccountNumber(String accountNumber);
	public boolean existsByAccountNumber(String accountNumber);
}
