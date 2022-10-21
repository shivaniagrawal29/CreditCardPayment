package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long>{

	public Customer findByCustomerNumber(String customerNumber);
	public Customer getCustomerByCustomerNumber(String customerNumber);
	public boolean existsByCustomerNumber(String customerNumber);
}
