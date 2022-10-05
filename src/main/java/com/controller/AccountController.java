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

import com.entity.Account;
import com.service.AccountService;

@RestController
@RequestMapping("/home")
public class AccountController {
	
	Log logger = LogFactory.getLog(AccountController.class);

	@Autowired
	AccountService accountService;
	
	@PostMapping("/addaccount")
	public ResponseEntity<String> addAccount(@RequestBody Account account) {
		accountService.addAccount(account);
		logger.info("addAccount successful.");
		return ResponseEntity.ok("Account is valid. "
				+ "\nAdded successfully in the database!");
	}

	@DeleteMapping("/removeaccount/{id}")
	public ResponseEntity<String> removeAccount(@PathVariable long id) throws Throwable {
		accountService.removeAccount(id);
		logger.info("removeAccount successful.");
		return ResponseEntity.ok("Account removed successfully from the database!");
	}

	@PutMapping("/updateaccount/{id}")
	public ResponseEntity<String> updateAccount(@PathVariable long id, @RequestBody Account account) throws Throwable {
		accountService.updateAccount(id, account);
		logger.info("updateAccount successful.");
		return ResponseEntity.ok("Account is valid."
				+ "Updated successfully in the database!");
	}

	@GetMapping("/getaccount/{id}")
	public Account getAccount(@PathVariable long id) throws Throwable {
		Account a = accountService.getAccount(id);
		logger.info("getAccount successful.");
		return a;
	}

	@GetMapping("/getallaccounts")
	public List<Account> getAllAccounts() {
		List<Account> la = accountService.getAllAccounts();
		logger.info("getAllAccounts successful.");
		return la;
	}
	
}
