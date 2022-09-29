package com.service;

import org.springframework.stereotype.Service;

import com.entity.User;

@Service
public interface IUserService {
	
	User signIn(User user);
	
	User signOut(User user);
	
	Long changePassword(long id, User user);

}
