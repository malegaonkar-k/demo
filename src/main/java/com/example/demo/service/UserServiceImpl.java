package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;

@Service
public class UserServiceImpl implements UserService {

	//@Autowired
	//private UserDao userDao;
	
	@Override
	public User getUser() {
		return new User(1,"keshav");
	}

}
