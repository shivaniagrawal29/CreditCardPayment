package com.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private long tranId;
	
	@NotNull(message = "Card number cannot be null.")
	@Size(min=19,max=19)
	@Pattern(regexp="^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$")
	private String cardNumber ;
	
	@NotNull(message = "Transaction date cannot be null.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tranDate;
	
	@NotNull(message = "Status cannot be null.")
	private String status ;
	
	@DecimalMax("40000.0") @DecimalMin("1.0") 
	private double amount ;
	
	@NotNull(message = "Payment method cannot be null.")
	private String paymentMethod ;
	
	private String description ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_custId")
	@JsonBackReference
	Customer customer;
	
	public long getTranId() {
		return tranId;
	}
	public void setTranId(long tranId) {
		this.tranId = tranId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getTranDate() {
		return tranDate;
	}
	public void setTranDate(LocalDate tranDate) {
		this.tranDate = tranDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate + ", status="
				+ status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description=" + description
				+ ", customer=" + customer + "]";
	}

	
}