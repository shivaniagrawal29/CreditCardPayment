package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.advices.ResourceNotFoundException;
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
		c1.setStatementNumber("1234");
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Mockito.when(statementrepo.save(c1)).thenReturn(c1);
		assertThat(statementservice.addStatement(c1)).isEqualTo(c1);
	}

	@Test
	void testRemoveStatement() {
		Statement c1 = new Statement();
		c1.setStatementNumber("1234");
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = c1;
		Mockito.when(statementrepo.findByStatementNumber("1234")).thenReturn(c2);
		Mockito.when(statementrepo.existsByStatementNumber(c1.getStatementNumber())).thenReturn(false);
		assertFalse(statementrepo.existsByStatementNumber(c1.getStatementNumber()));		
	}

	@Test
	void testUpdateStatement() throws Throwable {
		Statement c1 = new Statement();
		c1.setStatementNumber("1234");
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = c1;
		Mockito.when(statementrepo.findByStatementNumber("1234")).thenReturn(c2);
		Mockito.when(statementrepo.save(c1)).thenReturn(c1);
		
		c1.setStatementNumber("1234");
		c1.setDueAmount(1000);
		c1.setDueDate(LocalDate.of(2019, 8, 23));
		c1.setBillingDate(LocalDate.of(2019, 9, 23));
		
		assertThat(statementservice.updateStatement("1234", c1)).isEqualTo(c1);
	}

	@Test
	void testGetStatement() throws Throwable {
		Statement c1 = new Statement();
		c1.setStatementNumber("1234");
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = c1;
		Mockito.when(statementrepo.findByStatementNumber("1234")).thenReturn(c2);
		assertThat(statementservice.getStatement("1234")).isEqualTo(c1);
	}

	@Test
	void testGetAllStatements() throws ResourceNotFoundException {
		Statement c1 = new Statement();
		c1.setStatementNumber("1234");
		c1.setDueAmount(2000);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = new Statement();
		c2.setStatementNumber("5678");
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
	void testGetBilledStatements() throws ResourceNotFoundException {
		Statement c1 = new Statement();
		c1.setStatementNumber("1234");
		c1.setDueAmount(0);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = new Statement();
		c2.setStatementNumber("5678");
		c2.setDueAmount(3000);
		c2.setDueDate(LocalDate.of(2017, 8, 23));
		c2.setBillingDate(LocalDate.of(2017, 9, 23));
		
		List<Statement> billedstmts = new ArrayList<>();
        List<Statement> statements = new ArrayList<>();
        statements.add(c1);
        statements.add(c2);
        
        for(Statement s : statements)
        {
            if(s.getDueAmount() == 0)
                billedstmts.add(s);
        }
        
        Mockito.when(statementrepo.findAll()).thenReturn(billedstmts);
        assertThat(statementservice.getBilledStatements()).isEqualTo(billedstmts); 
	}

	@Test
	void testGetUnbilledStatements() throws ResourceNotFoundException {
		Statement c1 = new Statement();
		c1.setStatementNumber("1234");
		c1.setDueAmount(0);
		c1.setDueDate(LocalDate.of(2016, 8, 23));
		c1.setBillingDate(LocalDate.of(2016, 9, 23));
		
		Statement c2 = new Statement();
		c2.setStatementNumber("5678");
		c2.setDueAmount(3000);
		c2.setDueDate(LocalDate.of(2017, 8, 23));
		c2.setBillingDate(LocalDate.of(2017, 9, 23));
		
		List<Statement> unbilledstmts = new ArrayList<>();
        List<Statement> statements = new ArrayList<>();
        statements.add(c1);
        statements.add(c2);
        
        for(Statement s : statements)
        {
            if(s.getDueAmount() > 0)
                unbilledstmts.add(s);
        }
        
        Mockito.when(statementrepo.findAll()).thenReturn(unbilledstmts);
        assertThat(statementservice.getUnbilledStatements()).isEqualTo(unbilledstmts); 
	}

}
