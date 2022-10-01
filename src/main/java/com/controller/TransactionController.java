package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(path="/home")
public class TransactionController {
	
	@Autowired
    TransactionService transcontrol;
	
	@PostMapping ("addtransaction")
	public ResponseEntity<String> addTransaction( @RequestBody Transaction transaction) {
		
		Transaction transaction1=transcontrol.addTransaction(transaction);
		ResponseEntity re=new ResponseEntity<String>("Added Transaction Sucessfully !",HttpStatus.OK);
		return re ;
	//	return transaction1;
	}

	@DeleteMapping("deletetransaction/{id}")
	public ResponseEntity<String> removeTransaction(@PathVariable long id) {
	     
        Transaction transaction =transcontrol.removeTransaction(id);
    	ResponseEntity re=new ResponseEntity<String>("Deleted Transaction Sucessfully !",HttpStatus.OK);
		return re;
		//return transaction;
	}

    @PutMapping("updatetransaction/{id}")
	public ResponseEntity<String> updateTransaction(@PathVariable long id,@RequestBody Transaction transaction) {
	
	 Transaction transaction1=transcontrol.updateTransaction(id, transaction);
		ResponseEntity re=new ResponseEntity<String>("Updated Transaction Sucessfully !",HttpStatus.OK);
		return re;
		//return transaction1;
		
	}


	@GetMapping("getalltransactions")
	public List<Transaction> getAllTransaction() {
		List<Transaction>transactions=transcontrol.getAllTransaction();
		return transactions;
	}

	
	
}