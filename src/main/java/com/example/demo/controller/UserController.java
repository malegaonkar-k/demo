package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/hi")
	public ResponseEntity<User> getUser(){
		User user=userService.getUser();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}  

}
