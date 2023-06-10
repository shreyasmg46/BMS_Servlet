package com.cruds.bms.entity;

public class User{
	
	private String userName;
	private String password;
	private String phoneNo;
	private String email;
	private String role;
	
	public User(String userName, String role) {
		super();
		this.userName = userName;
		this.role = role;
	}

	public User(String userName, String password, String phoneNo, String email, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.email = email;
		this.role = role;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", role=" + role + "]";
	}


}
