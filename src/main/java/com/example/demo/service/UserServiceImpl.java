package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	//@Autowired
	//private UserDao userDao;
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public User getUser() {
		int id =1 ;
		Optional<User> user = repository.findById(id);
		return user.get();
		//return user.orElseThrow(()-> new UserNotFoundException("could not found user of id "+id));
	}

}
