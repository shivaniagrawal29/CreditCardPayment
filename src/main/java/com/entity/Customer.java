package com.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends User{

	
	@Id
	private long customerId;
    private String name;
    private String email;
    private String contactNo;
    private LocalDate dob;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> accounts;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<CreditCard> creditcards;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="fk_userId",referencedColumnName = "userId")
//    User user;
    
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
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<CreditCard> getCreditcards() {
		return creditcards;
	}
	public void setCreditcards(List<CreditCard> creditcards) {
		this.creditcards = creditcards;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", addresses=" + addresses + ", accounts=" + accounts + ", creditcards=" + creditcards + "]";
	}
	
	
}
