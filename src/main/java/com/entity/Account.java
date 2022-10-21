package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private long accountId;

	@Column(unique=true) 
	@Pattern(regexp = "^\\d{12}$", message = "Account number should be of 12 digits.")
	@NotNull
	private String accountNumber;
	
	@NotNull(message = "Account name cannot be null")
	@Size(min = 2, max = 20, message = "Account name should be at least 2 characters long.")
	private String accountName;
	
	@NotNull(message = "Balance cannot be null")
	@Min(value = 0, message = "Due amount cannot be negative.")
	private double balance;
	
	@NotBlank(message = "Account type cannot be blank")
	private String accountType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_custId")
	@JsonBackReference
	Customer customer;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName
				+ ", balance=" + balance + ", accountType=" + accountType + ", customer=" + customer + "]";
	}
	
}
