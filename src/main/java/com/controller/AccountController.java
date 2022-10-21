package com.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advices.EntityAlreadyExistsException;
import com.advices.NoRecordFoundException;
import com.entity.Account;
import com.service.AccountService;

@RestController
@RequestMapping("/home")
public class AccountController {
	
	Log logger = LogFactory.getLog(AccountController.class);

	@Autowired
	AccountService accountService;
	
	@PostMapping("/addaccount")
	public ResponseEntity<String> addAccount(@RequestBody Account account)throws Throwable {
	try {
		accountService.addAccount(account);
		logger.info("addAccount successful.");
		return ResponseEntity.ok("Account details are valid. "+ "\nAdded successfully in the database!");
	}
	catch(EntityAlreadyExistsException e)
    {
 	   throw new EntityAlreadyExistsException("Account already exists in database !!");
    }
	}

	@DeleteMapping("/removeaccount/{accountNumber}")
	public ResponseEntity<String> removeAccount(@PathVariable String accountNumber) throws Throwable {
		accountService.removeAccount(accountNumber);
		logger.info("removeAccount successful.");
		return ResponseEntity.ok("Account removed successfully from the database!");
	}

	@PutMapping("/updateaccount/{accountNumber}")
	public ResponseEntity<String> updateAccount(@PathVariable String accountNumber, @RequestBody Account account) throws Throwable {
		accountService.updateAccount(accountNumber, account);
		logger.info("updateAccount successful.");
		return ResponseEntity.ok("Account is valid."
				+ "Updated successfully in the database!");
	}

	@GetMapping("/getaccount/{accountNumber}")
	public Account getAccount(@PathVariable String accountNumber) throws Throwable {
		Account a = accountService.getAccount(accountNumber);
		logger.info("getAccount successful.");
		return a;
	}

	@GetMapping("/getallaccounts")
	public List<Account> getAllAccounts()throws Throwable {
		List<Account> accounts = accountService.getAllAccounts();
		if(accounts.isEmpty()) {
			   throw new NoRecordFoundException("NO Records found in database !!");
		}
		logger.info("getAllAccounts successful.");
		return accounts;
	}
	
}
