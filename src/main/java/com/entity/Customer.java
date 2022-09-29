package com.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private long userid;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	List<Address> address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	List<CreditCard> creditcards;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<CreditCard> getCreditcards() {
		return creditcards;
	}

	public void setCreditcards(List<CreditCard> creditcards) {
		this.creditcards = creditcards;
	}

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + ", creditcards=" + creditcards + "]";
	}

	
	
}
