package com.service;

import java.util.List;

import com.entity.Statement;

public interface IStatementService {

	Statement addStatement(Statement statement);
	
	Statement removeStatement(long id) throws Throwable;
	
	Statement updateStatement(long id, Statement statement) throws Throwable;
	
	Statement getStatement(long id) throws Throwable;
	
	List<Statement> getAllStatements()throws Throwable;
	
	List<Statement> getBilledStatements();
	
	List<Statement> getUnbilledStatements();
	
}
