package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Statement;
import com.repository.IStatementRepository;

@Service
public class StatementService implements IStatementService {

	@Autowired
	IStatementRepository statementRepo;
	
	@Override
	public Statement addStatement(Statement statement) {
		statementRepo.save(statement);
		return statement;
	}

	@Override
	public Statement removeStatement(long id) {
		Statement removedStmt = statementRepo.findById(id).orElseThrow();
		statementRepo.deleteById(id);
		return removedStmt;
	}

	@Override
	public Statement updateStatement(long id, Statement statement) {
		Statement originalStmt = statementRepo.findById(id).orElseThrow();
		
		originalStmt.setDueAmount(statement.getDueAmount());
		originalStmt.setBillingDate(statement.getBillingDate());
		originalStmt.setDueDate(statement.getDueDate());
//		originalStmt.setCustomer(statement.getCustomer());
		
		statementRepo.save(originalStmt);
		return originalStmt;
	}

	@Override
	public Statement getStatement(long id) {
		return statementRepo.findById(id).orElseThrow();
	}

	@Override
	public List<Statement> getAllStatements() {
		return statementRepo.findAll();
	}

	@Override
	public List<Statement> getBilledStatements() {
		List<Statement> stmtList = statementRepo.findAll();
		for(Statement s : stmtList) {
			if(s.getDueAmount() != 0)
				stmtList.remove(s);
		}
		
		return stmtList;
	}

	@Override
	public List<Statement> getUnbilledStatements() {
		List<Statement> stmtList = statementRepo.findAll();
		for(Statement s : stmtList) {
			if(s.getDueAmount() == 0) 
				stmtList.remove(s);
		}
		
		return stmtList;
	}
	
}