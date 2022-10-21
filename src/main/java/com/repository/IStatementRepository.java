package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Statement;

@Repository
public interface IStatementRepository extends JpaRepository<Statement, Long> {

	public Statement findByStatementNumber(String statementNumber);
	public Statement getStatementByStatementNumber(String statementNumber);
	public boolean existsByStatementNumber(String statementNumber);
}
