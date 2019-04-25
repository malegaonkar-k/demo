package com.example.demo.service;

public class UserNotFoundException extends RuntimeException  {
	UserNotFoundException(String message){
		super(message);
	}
	
	UserNotFoundException(String message,Throwable cause){
		super(message,cause);
	}
	
	UserNotFoundException(){
		super();
	}
	
	
	
}
