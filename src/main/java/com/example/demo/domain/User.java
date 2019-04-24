package com.example.demo.domain;

public class User {
	private int user;
	private String userName;
	
	public User(){
		
	}

	public User(int user, String userName) {
		super();
		this.user = user;
		this.userName = userName;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
