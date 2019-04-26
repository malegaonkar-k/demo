package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.domain.User;

public interface UserService {
	
	public User getUser();

	public User getUserById(int id);

	public List<User> getUserAll();

	public User saveUser(@Valid User user);

	public User updateUser(int userId, @Valid User user);
}
