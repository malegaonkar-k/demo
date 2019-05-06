package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="User")
 public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@NotEmpty(message = "Please provide a name")
	@Column(name = "user_name")
	private String userName;
	
	@NotEmpty(message = "Please provide a password")
	@Column(name="user_password")
	private String userPassword;
	

	public User() {

	}

	public User(int user, String userName) {
		super();
		this.userId = user;
		this.userName = userName;
	}

	public User(int i, String n, String p) {
		this.userId=i;
		this.userName=n;
		this.userPassword=p;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int user) {
		this.userId = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
