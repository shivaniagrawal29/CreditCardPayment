package com.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Transaction {

	@Id
	@GeneratedValue
	private long tranId;
	
	@Column(unique=true) 
	@Pattern(regexp = "^\\d{8}$", message = "Transaction number should be of 8 digits.")
	@NotNull
	private String tranNumber;
	
	@NotNull(message = "Card number cannot be null.")
	@Size(min=19,max=19)
	@Pattern(regexp="^[0-9]{4}[ ][0-9]{4}[ ][0-9]{4}[ ][0-9]{4}$")
	private String cardNumber ;
	
	@NotNull(message = "Transaction date cannot be null.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tranDate;
	
	@NotNull(message = "Status cannot be null.")
	private String status ;
	
	private String description ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_custId")
	@JsonBackReference
	Customer customer;
	
	public String getTranNumber() {
		return tranNumber;
	}
	public void setTranNumber(String tranNumber) {
		this.tranNumber = tranNumber;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Transaction [tranNumber=" + tranNumber + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate
				+ ", status=" + status + ", description=" + description + ", customer=" + customer + "]";
	}

	
}