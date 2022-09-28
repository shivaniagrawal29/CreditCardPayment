package com.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	
	
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	List<CreditCard> creditcards;
	
}
