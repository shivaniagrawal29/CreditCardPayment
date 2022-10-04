package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

	public Account getAccountByAccountName(String accountName);
	
	@Query("SELECT a FROM Account a WHERE accountType=?1 ORDER BY accountName")
	public List<Account> getAccountByAccountTypeSorted(String accountType);
}
