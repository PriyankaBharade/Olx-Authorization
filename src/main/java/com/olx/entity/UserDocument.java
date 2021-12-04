package com.olx.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Users")
public class UserDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	public int id;
	public String username;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public String phone;
	public String roles;
	
	public UserDocument() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserDocument [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", phone=" + phone + ", roles=" + roles
				+ "]";
	}

	public UserDocument(int id, String username, String firstName, String lastName, String email, String password,
			String phone, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
