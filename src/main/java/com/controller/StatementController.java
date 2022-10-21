package com.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.advices.NoRecordFoundException;
import com.advices.ResourceNotFoundException;
import com.entity.Statement;
import com.service.StatementService;

@RestController
@RequestMapping("/home")
public class StatementController {

	Log logger = LogFactory.getLog(StatementController.class);
	
	@Autowired
	StatementService statementService;
	
	@PostMapping("/addstatement")
	public ResponseEntity<String> addStatement(@Valid @RequestBody Statement statement) {
		statementService.addStatement(statement);
		logger.info("addStatement successful.");
		return ResponseEntity.ok("Statement is valid."
				+ "\nAdded successfully in the database!");
	}

	@DeleteMapping("/removestatement/{statementNumber}")
	public ResponseEntity<String> removeStatement(@PathVariable String statementNumber) throws Throwable {
		statementService.removeStatement(statementNumber);
		logger.info("removeStatement successful.");
		return ResponseEntity.ok("Statement removed successfully from the database!");
	}

	@PutMapping("/updatestatement/{statementNumber}")
	public ResponseEntity<String> updateStatement(@PathVariable String statementNumber, @Valid @RequestBody Statement statement) throws Throwable {
		statementService.updateStatement(statementNumber, statement);
		logger.info("updateStatement successful.");
		return ResponseEntity.ok("Statement is valid."
				+ "Updated successfully in the database!");
	}

	@GetMapping("/getstatement/{statementNumber}")
	public Statement getStatement(@PathVariable String statementNumber) throws Throwable {
		Statement s = statementService.getStatement(statementNumber);
		logger.info("getStatement successful.");
		return s;
	}

	@GetMapping("/getallstatements")
	public List<Statement> getAllStatements() throws Throwable{
		List<Statement> statements = statementService.getAllStatements();
		if(statements.isEmpty()) {
			   throw new NoRecordFoundException("NO Records found in database !!");
		}
		logger.info("getAllStatements successful.");
		return statements;
	}

	@GetMapping("/getbilledstatements")
	public List<Statement> getBilledStatements() throws ResourceNotFoundException {
		List<Statement> s = statementService.getBilledStatements();
		logger.info("getBilledStatements successful.");
		return s;
	}

	@GetMapping("/getunbilledstatements")
	public List<Statement> getUnbilledStatements() throws ResourceNotFoundException {
		List<Statement> s = statementService.getUnbilledStatements();
		logger.info("getUnbilledStatements successful.");
		return s;
	}
	
}
