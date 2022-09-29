package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public User changePassword(long id, User user) {
		
		User u1 = userRepo.findById(id).orElseThrow();
		u1.setPassword(user.getPassword());
		userRepo.save(u1);
		return u1;
	}

}
