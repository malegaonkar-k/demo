package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@MockBean
	private UserController userController;

	final static String baseUrl = "http://localhost:8083/demo";
	final static String GET_USER_BY_ID = baseUrl + "/users/1";
	


	@Test
	public void testGetUser() throws Exception {
		User mockUser = new User(1, "Ramesh01", " ");
		ResponseEntity<User> userResponse = new ResponseEntity<>(mockUser, HttpStatus.OK);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> resultString = restTemplate.getForEntity(GET_USER_BY_ID, String.class);
		System.out.println(resultString);
		Assert.assertThat(resultString.getStatusCode(), equalTo(HttpStatus.OK));
		assertEquals(true, resultString.getBody().contains("userId"));

		User resultUser = restTemplate.getForObject(GET_USER_BY_ID, User.class);
		assertEquals(1, resultUser.getUserId());
		assertEquals(mockUser, resultUser);

	}
	
	@Test
	public void testGetUserByIdWhenThrowUserNotFoundException(){
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> resultString = restTemplate.getForEntity(baseUrl + "/users/900", String.class);
		System.out.println(resultString);
	//	Assert.assertThat(resultString.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
		//assertEquals(true, resultString.getBody().contains("userId"));
				
	}
	
	@Test
	public void testGetAllUser(){
		
	}

}
