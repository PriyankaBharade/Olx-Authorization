package com.olx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	public int id;
	@Column(name ="username")
	public String username;
	@Column(name ="firstName")
	public String firstName;
	@Column(name ="lastName")
	public String lastName;
	@Column(name ="email")
	public String email;
	@Column(name ="password")
	public String password;
	@Column(name ="phone")
	public String phone;
	@Column(name ="roles")
	public String roles;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(int id, String username, String firstName, String lastName, String email, String password,
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
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
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
