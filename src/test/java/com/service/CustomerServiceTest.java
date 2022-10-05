package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Customer;
import com.repository.ICustomerRepository;

@SpringBootTest
class CustomerServiceTest {

	@Autowired
	CustomerService customerservice;
	
	@MockBean
	ICustomerRepository customerrepo;
	
	@Test
	void testAddCustomer() throws Throwable{
		Customer c1 = new Customer();
		c1.setCustomerId(1);
		c1.setName("Varun");
		c1.setEmail("varun@gmail.com");
		c1.setContactNo("9826754256");
		c1.setDob(LocalDate.of(2000, 12, 23));
		
		Mockito.when(customerrepo.save(c1)).thenReturn(c1);
		assertThat(customerservice.addCustomer(c1)).isEqualTo(c1);
	}

	@Test
	void testRemoveCustomer() {
		Customer c1 = new Customer();
		c1.setCustomerId(1);
		c1.setName("Varun");
		c1.setEmail("varun@gmail.com");
		c1.setContactNo("9826754256");
		c1.setDob(LocalDate.of(2000, 12, 23));
		
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(customerrepo.findById((long) 1)).thenReturn(c2);
		Mockito.when(customerrepo.existsById(c1.getCustomerId())).thenReturn(false);
		assertFalse(customerrepo.existsById(c1.getCustomerId()));
	}

	@Test
	void testUpdateCustomer() throws Throwable {
		Customer c1 = new Customer();
		c1.setCustomerId(1);
		c1.setName("Varun");
		c1.setEmail("varun@gmail.com");
		c1.setContactNo("9826754256");
		c1.setDob(LocalDate.of(2000, 12, 23));
		
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(customerrepo.findById((long) 1)).thenReturn(c2);
		Mockito.when(customerrepo.save(c1)).thenReturn(c1);
		
		c1.setName("Vishal");
		c1.setEmail("vishal@gmail.com");
		c1.setContactNo("2898972679");
		c1.setDob(LocalDate.of(2000, 11, 23));
		
		assertThat(customerservice.updateCustomer(1, c1)).isEqualTo(c1);
	}

	@Test
	void testGetCustomer() throws Throwable {
		Customer c1 = new Customer();
		c1.setCustomerId(1);
		c1.setName("Varun");
		c1.setEmail("varun@gmail.com");
		c1.setContactNo("9826754256");
		c1.setDob(LocalDate.of(2000, 12, 23));
		
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(customerrepo.findById((long) 1)).thenReturn(c2);
		assertThat(customerservice.getCustomer(1)).isEqualTo(c1);
	}

	@Test
	void testGetAllCustomers()throws Throwable {
		Customer c1 = new Customer();
		c1.setCustomerId(1);
		c1.setName("Varun");
		c1.setEmail("varun@gmail.com");
		c1.setContactNo("9826754256");
		c1.setDob(LocalDate.of(2000, 12, 23));
		
		Customer c2 = new Customer();
		c2.setCustomerId(2);
		c2.setName("Arun");
		c2.setEmail("arun@gmail.com");
		c2.setContactNo("9827462256");
		c2.setDob(LocalDate.of(2000, 12, 23));
		
		List<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c2);
		
		Mockito.when(customerrepo.findAll()).thenReturn(customers);
		assertThat(customerservice.getAllCustomers()).isEqualTo(customers);
	}

}
