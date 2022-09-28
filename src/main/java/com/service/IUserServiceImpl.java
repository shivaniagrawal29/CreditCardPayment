package com.service;

import com.entity.User;

public class IUserServiceImpl implements IUserService{
	
	@Override
	public User signIn(User user) 
	{
		return user;
	}
	
	@Override
	public User signOut(User user)
	{
		return user;
	}
	
	@Override
	public User changePassword(long id, User user)
	{
		
		return user;
	}
}
