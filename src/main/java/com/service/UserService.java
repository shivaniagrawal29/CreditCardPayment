package com.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.User;
import com.repository.IUserRepository;

@Service
@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public User signIn(User user) {
		userRepo.save(user);
		return user;
	}

	@Override
	public User signOut(User user) {
		User user1 = user;
		userRepo.deleteById(user.getUserId());
		return user1;
	}

	@Override
	public User changePassword(long id, User user) throws Throwable {
		Supplier s = ()-> new ResourceNotFoundException("Customer doesn't exist in the database.");
		User u1 = userRepo.findById(id).orElseThrow(s);
		u1.setPassword(user.getPassword());
		userRepo.save(u1);
		return u1;
	}

}
