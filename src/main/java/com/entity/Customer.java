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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Customer{ 

	
	@Id
	@GeneratedValue
	private long customerId;
	
	@Size(min = 3, message = "The name is invalid")
    private String name;
	
	@Email
    private String email;
	
	@Pattern(regexp = "^[789]\\d{9}$")
    private String contactNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    @JoinColumn(name = "fk_accountId")
//    @JsonBackReference
    private List<Account> accounts;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<CreditCard> creditcards;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<Transaction> transactions;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_userId")//,referencedColumnName = "userId"
    User users;
    
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
