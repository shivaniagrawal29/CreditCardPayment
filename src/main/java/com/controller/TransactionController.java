package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Transaction;
import com.service.TransactionService;

@Validated
@RestController
@RequestMapping(path="/home")
public class TransactionController {

	Log logger = LogFactory.getLog(TransactionController.class);
	
	@Autowired
	TransactionService transcontrol;

	@PostMapping ("addtransaction")
	public ResponseEntity<String> addTransaction( @Valid @RequestBody Transaction transaction) {

		transcontrol.addTransaction(transaction);
		logger.info("addtransaction successful.");
		ResponseEntity<String> re=new ResponseEntity<>("Added Transaction Sucessfully !",HttpStatus.OK);
		return re ;
	}

	@DeleteMapping("deletetransaction/{id}")
	public ResponseEntity<String> removeTransaction(@PathVariable long id) throws Throwable {
		transcontrol.removeTransaction(id);
		logger.info("deletetransaction successful.");
		ResponseEntity<String> re=new ResponseEntity<>("Deleted Transaction Sucessfully !",HttpStatus.OK);
		return re;
	}

	@PutMapping("updatetransaction/{id}")
	public ResponseEntity<String> updateTransaction(@PathVariable long id,@Valid @RequestBody Transaction transaction) throws Throwable{

		transcontrol.updateTransaction(id, transaction);
		logger.info("updatetransaction successful.");
		ResponseEntity<String> re=new ResponseEntity<>("Updated Transaction Sucessfully !",HttpStatus.OK);
		return re;
	}

	@GetMapping("getalltransactions")
	public List<Transaction> getAllTransaction() {
		List<Transaction>transactions=transcontrol.getAllTransaction();
		logger.info("getalltransactions successful.");
		return transactions;
	}

	@GetMapping("gettransaction/{id}")
	public Transaction getTransactionDetails(@PathVariable long id) throws Throwable {
		Transaction transaction=transcontrol.getTransactionDetails(id);
		logger.info("getTransactionDetails successful.");
		return transaction;
	}



}