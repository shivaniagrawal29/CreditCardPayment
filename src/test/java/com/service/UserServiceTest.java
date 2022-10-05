package com.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.entity.User;
import com.repository.IUserRepository;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	UserService userservice;
	
	@MockBean
	IUserRepository userrepo;

	@Test
	void testSignIn() {
		User u1 = new User();
		u1.setUserId(12345678);
		u1.setPassword("var@12msm3");
		
		Mockito.when(userrepo.save(u1)).thenReturn(u1);
		assertThat(userservice.signIn(u1)).isEqualTo(u1);
	}

	@Test
	void testSignOut() {
		User u1 = new User();
		u1.setUserId(12345678);
		u1.setPassword("var@12msm3");
		
		Mockito.when(userrepo.save(u1)).thenReturn(u1);
		assertThat(userservice.signOut(u1)).isEqualTo(u1);
	}

	@Test
	void testChangePassword() throws Throwable {
		User u1 = new User();
		u1.setUserId(12345678);
		u1.setPassword("var@12msm3");
		
		Optional<User> u2 = Optional.of(u1);
		Mockito.when(userrepo.findById((long) 12345678)).thenReturn(u2);
		Mockito.when(userrepo.save(u1)).thenReturn(u1);
		
		u1.setPassword("gaf42@xnskAs");
		
		assertThat(userservice.changePassword(12345678, u1)).isEqualTo(u1);
	}

}
