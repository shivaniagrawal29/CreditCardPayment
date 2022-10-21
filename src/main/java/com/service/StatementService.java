package com.service;

import java.util.ArrayList;
import java.util.List;

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
		return statementRepo.save(statement);
	}

	@Override
	public Statement removeStatement(String statementNumber) throws Throwable {
		Statement removedStmt = statementRepo.findByStatementNumber(statementNumber);
		if(removedStmt==null){
            throw new ResourceNotFoundException("Statement doesn't exist in the database.");
        }
		statementRepo.delete(statementRepo.findByStatementNumber(statementNumber));
		return removedStmt;
	}

	@Override
	public Statement updateStatement(String statementNumber, Statement statement) throws Throwable {
		Statement originalStmt = statementRepo.findByStatementNumber(statementNumber);
		if(originalStmt==null){
            throw new ResourceNotFoundException("Statement doesn't exist in the database.");
        }
		originalStmt.setDueAmount(statement.getDueAmount());
		originalStmt.setBillingDate(statement.getBillingDate());
		originalStmt.setDueDate(statement.getDueDate());
		
		statementRepo.save(originalStmt);
		return originalStmt;
	}

	@Override
	public Statement getStatement(String statementNumber) throws Throwable {
		Statement s = statementRepo.findByStatementNumber(statementNumber);
		if(s==null){
            throw new ResourceNotFoundException("Statement doesn't exist in the database.");
        }
		return s;
	}

	@Override
	public List<Statement> getAllStatements() throws ResourceNotFoundException {
		if(statementRepo.findAll().isEmpty())
			throw new ResourceNotFoundException("Statement doesn't exist in the database."); 
		
		return statementRepo.findAll();
	}
	
	@Override
    public List<Statement> getBilledStatements() throws ResourceNotFoundException {
        List<Statement> stmtList = statementRepo.findAll();
        List<Statement> billedstmts = new ArrayList<>();
        for(Statement s : stmtList) {
            if(s.getDueAmount() == 0)
                billedstmts.add(s);
        }
        
        if(billedstmts.isEmpty())
        	throw new ResourceNotFoundException("Billed statement doesn't exist in the database."); 
        
        return billedstmts;
    }



   @Override
    public List<Statement> getUnbilledStatements() throws ResourceNotFoundException {
        List<Statement> stmtList = statementRepo.findAll();
        List<Statement> unbilledstmts = new ArrayList<>();
        for(Statement s : stmtList) {
            if(s.getDueAmount() > 0)
                unbilledstmts.add(s);
        }    
        
        if(unbilledstmts.isEmpty())
        	throw new ResourceNotFoundException("Unbilled statement doesn't exist in the database."); 
        
        return unbilledstmts;
    }
	
}
