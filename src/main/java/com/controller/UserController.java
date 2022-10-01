package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping(path = "/home")
public class UserController {
	
	@Autowired
	UserService usi;
	
	@RequestMapping("/signin/{user1}")
	public User signIn(@RequestBody User user1) 
	{
		return user1;
	}
	
	@RequestMapping("/signout/{user2}")
	public User signOut(@RequestBody User user2) 
	{
		return user2;
	}
	
	@RequestMapping("/changepassword/{userid3}")
	public User changePassword(@PathVariable Long userid3, @RequestBody User user1 )
	{
		User user3 = usi.changePassword(userid3, user1);
		return user3;
	}
	
}
