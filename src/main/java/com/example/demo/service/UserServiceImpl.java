package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	// @Autowired
	// private UserDao userDao;

	@Autowired
	private UserRepository repository;

	@Override
	public User getUser() {
		int id = 1;
		Optional<User> user = repository.findById(id);
		return user.get();
		// return user.orElseThrow(()-> new UserNotFoundException("could not
		// found user of id "+id));
	}

	@Override
	public User getUserById(int id) {
		Optional<User> container = repository.findById(id);
		return container.orElseThrow(() -> new UserNotFoundException("could not found user of id " + id));
	}

	@Override
	public List<User> getUserAll() {
		return repository.findAll();
	}

	@Override
	public User saveUser(@Valid User user) {
		@Valid
		User tempUser = repository.save(user);
		return tempUser;
	}

	@Override
	public User updateUser(int userId, @Valid User user) {
		User tempUser = getUserById(userId);
		tempUser.setUserName(user.getUserName());
		return saveUser(tempUser);
	}

}
