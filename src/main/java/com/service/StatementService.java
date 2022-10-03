package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
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
	public Statement removeStatement(long id) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Statement doesn't exist in the database.");
		Statement removedStmt = statementRepo.findById(id).orElseThrow(s);
		statementRepo.deleteById(id);
		return removedStmt;
	}

	@Override
	public Statement updateStatement(long id, Statement statement) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Statement doesn't exist in the database.");
		Statement originalStmt = statementRepo.findById(id).orElseThrow(s);
		
		originalStmt.setDueAmount(statement.getDueAmount());
		originalStmt.setBillingDate(statement.getBillingDate());
		originalStmt.setDueDate(statement.getDueDate());
//		originalStmt.setCustomer(statement.getCustomer());
		
		statementRepo.save(originalStmt);
		return originalStmt;
	}

	@Override
	public Statement getStatement(long id) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Statement doesn't exist in the database.");
		return statementRepo.findById(id).orElseThrow(s);
	}

	@Override
	public List<Statement> getAllStatements() {
		return statementRepo.findAll();
	}
	
	@Override
    public List<Statement> getBilledStatements() {
        List<Statement> stmtList = statementRepo.findAll();
        List<Statement> billedstmts = new ArrayList<>();
        for(Statement s : stmtList) {
            if(s.getDueAmount() == 0)
                billedstmts.add(s);
        }
        return billedstmts;
    }



   @Override
    public List<Statement> getUnbilledStatements() {
        List<Statement> stmtList = statementRepo.findAll();
        List<Statement> unbilledstmts = new ArrayList<>();
        for(Statement s : stmtList) {
            if(s.getDueAmount() > 0)
                unbilledstmts.add(s);
        }        
        return unbilledstmts;
    }
	
}
