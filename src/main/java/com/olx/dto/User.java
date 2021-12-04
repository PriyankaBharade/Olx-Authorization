package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User Model")
public class User {
	@ApiModelProperty("Unique indentifier of the User")
	public int id;
	@ApiModelProperty("User name")
	public String username;
	@ApiModelProperty("User's First name")
	public String firstName;
	@ApiModelProperty("User's Last name")
	public String lastName;
	@ApiModelProperty("User's email")
	public String email;
	@ApiModelProperty("Password of the user")
	public String password;
	@ApiModelProperty("Phone number of the user")
	public String phone;
	@ApiModelProperty("Roles of the user")
	public String roles;
	
	
	public User() {
		super();
	}
	
	public User(int id, String username, String firstName, String lastName, String email, String password, String phone,
			String roles) {
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
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", phone=" + phone + ", roles=" + roles + "]";
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
