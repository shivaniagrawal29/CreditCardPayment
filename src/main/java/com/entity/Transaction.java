package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private long tranId;
	private String cardNumber ;
	private LocalDate tranDate;
	private String Status ;
	private double amount ;
	private String paymentMethod ;
	private String description ;
	
	@ManyToOne
	@JoinColumn(name="Tid")//,referencedColumnName = "userId"
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
	public long getTranld() {
		return tranId;
	}
	public void setTranld(long tranld) {
		this.tranId = tranld;
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
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
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
		return "Transaction [tranId=" + tranId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate + ", Status="
				+ Status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description=" + description
				+ ", customer=" + customer + "]";
	}

	
}