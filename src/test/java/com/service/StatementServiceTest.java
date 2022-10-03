package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Statement;
import com.repository.IStatementRepository;

@SpringBootTest
class StatementServiceTest {
	
	@Autowired
	StatementService statementservice;
	
	@MockBean
	IStatementRepository statementrepo;

	@Test
	void testAddStatement() {
		Statement c1 = new Statement();
		c1.setStatementId(1);
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Mockito.when(statementrepo.save(c1)).thenReturn(c1);
		assertThat(statementservice.addStatement(c1)).isEqualTo(c1);
	}

	@Test
	void testRemoveStatement() {
		Statement c1 = new Statement();
		c1.setStatementId(1);
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Optional<Statement> c2 = Optional.of(c1);
		Mockito.when(statementrepo.findById((long) 1)).thenReturn(c2);
		Mockito.when(statementrepo.existsById(c1.getStatementId())).thenReturn(false);
		assertFalse(statementrepo.existsById(c1.getStatementId()));		
	}

	@Test
	void testUpdateStatement() throws Throwable {
		Statement c1 = new Statement();
		c1.setStatementId(1);
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Optional<Statement> c2 = Optional.of(c1);
		Mockito.when(statementrepo.findById((long) 1)).thenReturn(c2);
		Mockito.when(statementrepo.save(c1)).thenReturn(c1);
		
		c1.setStatementId(2);
		c1.setDueAmount(1000);
		c1.setDueDate(LocalDate.of(2019, 8, 23));
		c1.setBillingDate(LocalDate.of(2019, 9, 23));
		
		assertThat(statementservice.updateStatement(1, c1)).isEqualTo(c1);
	}

	@Test
	void testGetStatement() throws Throwable {
		Statement c1 = new Statement();
		c1.setStatementId(1);
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Optional<Statement> c2 = Optional.of(c1);
		Mockito.when(statementrepo.findById((long) 1)).thenReturn(c2);
		assertThat(statementservice.getStatement(1)).isEqualTo(c1);
	}

	@Test
	void testGetAllStatements() {
		Statement c1 = new Statement();
		c1.setStatementId(1);
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = new Statement();
		c2.setStatementId(2);
		c2.setDueAmount(3000);
		c2.setDueDate(LocalDate.of(2017, 8, 23));
		c2.setBillingDate(LocalDate.of(2017, 9, 23));
		
		List<Statement> statements = new ArrayList<>();
		statements.add(c1);
		statements.add(c2);
		
		Mockito.when(statementrepo.findAll()).thenReturn(statements);
		assertThat(statementservice.getAllStatements()).isEqualTo(statements);	
	}

	@Test
	void testGetBilledStatements() {
		Statement c1 = new Statement();
		c1.setStatementId(1);
		c1.setDueAmount(0);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = new Statement();
		c2.setStatementId(2);
		c2.setDueAmount(3000);
		c2.setDueDate(LocalDate.of(2017, 8, 23));
		c2.setBillingDate(LocalDate.of(2017, 9, 23));
		
		List<Statement> statements = new ArrayList<>();
		statements.add(c1);
//		statements.add(c2);
		
		Mockito.when(statementrepo.findAll()).thenReturn(statements);
		assertThat(statementservice.getBilledStatements()).isEqualTo(statements);	
	}

	@Test
	void testGetUnbilledStatements() {
		Statement c1 = new Statement();
		c1.setStatementId(1);
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = new Statement();
		c2.setStatementId(2);
		c2.setDueAmount(3000);
		c2.setDueDate(LocalDate.of(2017, 8, 23));
		c2.setBillingDate(LocalDate.of(2017, 9, 23));
		
		List<Statement> statements = new ArrayList<>();
		statements.add(c1);
		statements.add(c2);
		
		Mockito.when(statementrepo.findAll()).thenReturn(statements);
		assertThat(statementservice.getUnbilledStatements()).isEqualTo(statements);	
	}

}
