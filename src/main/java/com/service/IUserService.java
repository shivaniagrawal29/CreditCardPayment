package com.service;

import com.entity.User;

public interface IUserService {
	
	User signIn(User user);
	
	User signOut(User user);
	
	User changePassword(long id, User user);

}
