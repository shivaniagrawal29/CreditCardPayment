package com.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String cardName;
	private String cardType;
	private String cardNumber;
	private LocalDate expiryDate;
	private String bankName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid", referencedColumnName = "userId")
	@JsonBackReference
	Customer customer;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardName=" + cardName + ", cardType=" + cardType + ", cardNumber="
				+ cardNumber + ", expiryDate=" + expiryDate + ", bankName=" + bankName + ", customer=" + customer + "]";
	}

	
}
