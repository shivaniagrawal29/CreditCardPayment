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

import com.entity.Statement;
import com.service.StatementService;

@RestController
@RequestMapping("/home")
public class StatementController {

//	Log logger = LogFactory.getLog(AccountController.class);
	
	@Autowired
	StatementService statementService;
	
	@PostMapping("/addstatement")
	public Statement addStatement(@RequestBody Statement statement) {
		Statement s = statementService.addStatement(statement);
//		logger.info("addStatement successful.");
		return s;
	}

	@DeleteMapping("/removestatement/{id}")
	public Statement removeStatement(@PathVariable long id) {
		Statement s = statementService.removeStatement(id);
//		logger.info("removeStatement successful.");
		return s;
	}

	@PutMapping("/updatestatement/{id}")
	public Statement updateStatement(@PathVariable long id, @RequestBody Statement statement) {
		Statement s = statementService.updateStatement(id, statement);
//		logger.info("updateStatement successful.");
		return s;
	}

	@GetMapping("/getstatement/{id}")
	public Statement getStatement(@PathVariable long id) {
		Statement s = statementService.getStatement(id);
//		logger.info("addStatement successful.");
		return s;
	}

	@GetMapping("/getallstatements")
	public List<Statement> getAllStatements() {
		List<Statement> s = statementService.getAllStatements();
//		logger.info("addStatement successful.");
		return s;
	}

	@GetMapping("/getbilledstatements")
	public List<Statement> getBilledStatements() {
		List<Statement> s = statementService.getBilledStatements();
//		logger.info("addStatement successful.");
		return s;
	}

	@GetMapping("/getunbilledstatements")
	public List<Statement> getUnbilledStatements() {
		List<Statement> s = statementService.getUnbilledStatements();
//		logger.info("addStatement successful.");
		return s;
	}
	
}
