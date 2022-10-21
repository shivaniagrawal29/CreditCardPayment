package com.service;

import java.util.List;

import com.entity.Statement;

public interface IStatementService {

	Statement addStatement(Statement statement);
	
	Statement removeStatement(String statementNumber) throws Throwable;
	
	Statement updateStatement(String statementNumber, Statement statement) throws Throwable;
	
	Statement getStatement(String statementNumber) throws Throwable;
	
	List<Statement> getAllStatements()throws Throwable;
	
	List<Statement> getBilledStatements() throws Throwable;
	
	List<Statement> getUnbilledStatements() throws Throwable;
	
}
