package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Users")
public class User{
    
	@Id
	@GeneratedValue
    private long userId;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", 
			message = "At least 8 chars\r\n"
					+ "\r\n"
					+ "Contains at least one digit\r\n"
					+ "\r\n"
					+ "Contains at least one lower alpha char and one upper alpha char\r\n"
					+ "\r\n"
					+ "Contains at least one char within a set of special chars (@#%$^ etc.)\r\n"
					+ "\r\n"
					+ "Does not contain space, tab, etc.\r\n"
					+ "\r\n")
    private String password;
    
//    @OneToOne(mappedBy = "user")
//    Customer customer;
    
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User [userId=" + userId + ", password=" + password + "]";
    }
}