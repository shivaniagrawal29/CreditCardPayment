package com.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Statement {

	@Id
	@GeneratedValue
	private long statementId;
	
	@Column(unique=true) 
	@NotNull
	@Pattern(regexp = "^\\d{8}$", message = "Statement number should be of 8 digits.")
	private String statementNumber;
	
	@Min(value = 0, message = "Due amount cannot be negative.")
	private double dueAmount;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate billingDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dueDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_custId")
	@JsonBackReference
	private Customer customer;

	
	public String getStatementNumber() {
		return statementNumber;
	}
	public void setStatementNumber(String statementNumber) {
		this.statementNumber = statementNumber;
	}
	public double getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Statement [statementNumber=" + statementNumber + ", dueAmount=" + dueAmount + ", billingDate="
				+ billingDate + ", dueDate=" + dueDate + ", customer=" + customer + "]";
	}
	

}
