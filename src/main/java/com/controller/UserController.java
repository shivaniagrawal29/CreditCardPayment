package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping(path = "/home")
public class UserController {
    
	Log logger = LogFactory.getLog(UserController.class);
	
    @Autowired
    UserService usi;
    
    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody User user1)
    {
    	usi.signIn(user1);
    	logger.info("signIn successful.");
        ResponseEntity<String> re = new ResponseEntity<String>("Sign In Successful !",HttpStatus.OK);
        return re;
    }
    
    @PostMapping("/signout")
    public ResponseEntity<String> signOut(@RequestBody User user2)
    {
    	usi.signOut(user2);
    	logger.info("signOut successful.");
        ResponseEntity<String> re = new ResponseEntity<String>("Sign Out Successful !",HttpStatus.OK);
        return re;
    }
    
    @PutMapping("/changepassword/{userid3}")
    public ResponseEntity<String> changePassword(@PathVariable Long userid3, @RequestBody User user1) throws Throwable
    {
        usi.changePassword(userid3, user1);
        logger.info("changePassword successful.");
        ResponseEntity<String> re = new ResponseEntity<String>("Password Changed Successfully",HttpStatus.OK);
        return re;
    }
    
}