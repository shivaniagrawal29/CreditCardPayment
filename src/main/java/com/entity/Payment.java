package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private long paymentId;
	
	@Column(unique=true) 
	@Pattern(regexp = "^\\d{8}$", message = "Payment number should be of 8 digits.")
	@NotNull
	private String paymentNumber;
	
	@NotNull
	private String method;
	
	@DecimalMax("100000.0") @DecimalMin("0.0") 
	private double amountDue;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_transId")
	@NotNull
	Transaction transaction;
	

	public String getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public double getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentNumber=" + paymentNumber + ", method=" + method + ", amountDue=" + amountDue
				+ ", transaction=" + transaction + "]";
	}
	
}
