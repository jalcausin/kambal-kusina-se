package com.kambalkusina.servlet;

public class User {
	String uname;
	String email;
	String code;
	
	public User() {
	}
	
	public User(String uname, String email, String code) {
		this.uname = uname;
		this.email = email;
		this.code = code;
	}
	
	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
