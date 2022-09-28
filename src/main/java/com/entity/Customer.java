package com.entity;



import java.time.LocalDate;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Customer {



   private String userId;
    private String name;
    private String email;
    private String contactNo;
    private LocalDate dob;
    private Address address;
    
    @Id
    @GeneratedValue
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }