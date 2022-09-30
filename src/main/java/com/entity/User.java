package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class User{
    
	@Id
    private long userId;
    private String password;
    
    @OneToOne(mappedBy = "user")
    Customer customer;
    
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