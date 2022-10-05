package com.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min = 2, max = 30, message = "Card Name should be less than 30 characters and not less than 2 characters")
	private String cardName;
	
	@NotNull
	private String cardType;
	
	@NotNull
	@Size(min=19,max=19,message="format of card number is xxxx xxxx xxxx xxxx")
	@Pattern(regexp = "^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$", message="format of card number is xxxx xxxx xxxx xxxx")
	private String cardNumber;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate expiryDate;
	
	@NotNull
	private String bankName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_custId")
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
