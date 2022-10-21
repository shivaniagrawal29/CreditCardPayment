package com.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer{ 

	@Id
	@GeneratedValue
	private long customerId;
	
	@Column(unique=true) 
	@Pattern(regexp = "^\\d{8}$", message = "Customer number should be of 8 digits.")
	@NotNull
	private String customerNumber;
	
	@Size(min = 2, message = "The name should be at least 2 characters long")
    private String name;
	
	@Column(unique=true) 
	@Email(message = "Email should be in the format: 'example@mail.com'")
    private String email;
	
	@Column(unique=true) 
	@Pattern(regexp = "^[789]\\d{9}$", message = "Phone number is not valid")
    private String contactNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_custId", referencedColumnName = "customerId")
    private List<Address> addresses;

    @OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_custId", referencedColumnName = "customerId")
    private List<Account> accounts;
    
    @OneToMany(targetEntity = CreditCard.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_custId", referencedColumnName = "customerId")
    List<CreditCard> creditcards;
    
    @OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_custId", referencedColumnName = "customerId")
    List<Transaction> transactions;
    
    @OneToMany(targetEntity = Statement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_custId", referencedColumnName = "customerId")
    private List<Statement> statements;
    
    
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public List<Statement> getStatements() {
		return statements;
	}
	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}
	
	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", name=" + name + ", email=" + email + ", contactNo="
				+ contactNo + ", dob=" + dob + ", addresses=" + addresses + ", accounts=" + accounts + ", creditcards="
				+ creditcards + ", transactions=" + transactions + ", statements=" + statements + "]";
	}
	
	
}
