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
    private List<Address> address;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> accounts;
    
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + "]";
	}
	
	
}
