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
		Statement s = statementService.addStatement(statement);
		logger.info("addStatement successful.");
		return ResponseEntity.ok("Statement is valid."
				+ "Added successfully in the database!");
//		return s;
	}

	@DeleteMapping("/removestatement/{id}")
	public ResponseEntity<String> removeStatement(@PathVariable long id) throws Throwable {
		Statement s = statementService.removeStatement(id);
		logger.info("removeStatement successful.");
		return ResponseEntity.ok("Statement removed successfully from the database!");
//		return s;
	}

	@PutMapping("/updatestatement/{id}")
	public ResponseEntity<String> updateStatement(@PathVariable long id, @Valid @RequestBody Statement statement) throws Throwable {
		Statement s = statementService.updateStatement(id, statement);
		logger.info("updateStatement successful.");
		return ResponseEntity.ok("Statement is valid."
				+ "Updated successfully in the database!");
//		return s;
	}

	@GetMapping("/getstatement/{id}")
	public Statement getStatement(@PathVariable long id) throws Throwable {
		Statement s = statementService.getStatement(id);
		logger.info("addStatement successful.");
		return s;
	}

	@GetMapping("/getallstatements")
	public List<Statement> getAllStatements() {
		List<Statement> s = statementService.getAllStatements();
		logger.info("addStatement successful.");
		return s;
	}

	@GetMapping("/getbilledstatements")
	public List<Statement> getBilledStatements() {
		List<Statement> s = statementService.getBilledStatements();
		logger.info("addStatement successful.");
		return s;
	}

	@GetMapping("/getunbilledstatements")
	public List<Statement> getUnbilledStatements() {
		List<Statement> s = statementService.getUnbilledStatements();
		logger.info("addStatement successful.");
		return s;
	}
	
}
