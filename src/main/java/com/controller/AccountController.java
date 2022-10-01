package com.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
//	Log logger = LogFactory.getLog(AccountController.class);

	@Autowired
	AccountService accountService;
	
	@PostMapping("/addaccount")
	public Account addAccount(@RequestBody Account account) {
		Account a = accountService.addAccount(account);
//		logger.info("addAccount successful.");
		return a;
	}

	@DeleteMapping("/removeaccount/{id}")
	public Account removeAccount(@PathVariable long id) {
		Account a = accountService.removeAccount(id);
//		logger.info("removeAccount successful.");
		return a;
	}

	@PutMapping("/updatecoder/{id}")
	public Account updateAccount(@PathVariable long id, @RequestBody Account account) {
		Account a = accountService.updateAccount(id, account);
//		logger.info("updateAccount sucessful.");
		return a;
	}

	@GetMapping("/getaccount/{id}")
	public Account getAccount(@PathVariable long id) {
		Account a = accountService.getAccount(id);
//		logger.info("getAccount successful.");
		return a;
	}

	@GetMapping("/getallaccounts")
	public List<Account> getAllAccounts() {
		List<Account> la = accountService.getAllAccounts();
//		logger.info("getAllAccounts successful.");
		return la;
	}
	
}
