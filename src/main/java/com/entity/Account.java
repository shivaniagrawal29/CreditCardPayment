package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private long accountId;
	
	@NotBlank(message = "Account name cannot be blank")
	@Size(min = 2, max = 20, message = "Account name should be at least 2 characters long")
	private String accountName;
	
	@NotNull
	@Min(value = 0, message = "Due amount cannot be negative.")
	private double balance;
	
	@NotBlank(message = "Account type cannot be blank")
	private String accountType;
	
	@ManyToOne //(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_customerId")//, referencedColumnName = "userId"
	@JsonBackReference
	Customer customer;
	
	@OneToOne //(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_stmtId")
	Statement statement;
	

	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
//	public Statement getStatement() {
//		return statement;
//	}
//
//	public void setStatement(Statement statement) {
//		this.statement = statement;
//	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", balance=" + balance
				+ ", accountType=" + accountType + ", customer=" + customer + ", statement=" +"]";
	}
	
}
