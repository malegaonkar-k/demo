package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserNotFoundException;
import com.example.demo.service.UserService;



@Validated
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/hi")
	public ResponseEntity<User> getUser() {
		User user = userService.getUser();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) {
		User user=null;
		try {
			 user = userService.getUserById(userId);	
		} catch (UserNotFoundException e) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		} 	
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getUserAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User temp = userService.saveUser(user);
		return new ResponseEntity<User>(temp, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value="id") int userId, @Valid @RequestBody User user){
		User temp= userService.updateUser(userId, user);		
		return new ResponseEntity<User>(temp,HttpStatus.OK);
	}
	
	
	/*
	 *
	 * @GetMapping("/users/seekers") public ResponseEntity<User>
	 * getAllSeekers(){ User user=userService.getUser(); return new
	 * ResponseEntity<User>(user,HttpStatus.OK); }
	 * 
	 * @GetMapping("/users/providers") public ResponseEntity<Set<User>>
	 * getAllProviders(){ Set<User> providers=null;//=userService.getUser();
	 * return new ResponseEntity<Set<User>>(providers,HttpStatus.OK); }
	 */
}
