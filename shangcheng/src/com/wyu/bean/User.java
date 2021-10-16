package com.wyu.bean;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String gender;
	private int flag;
	private int role;
	private String code;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User(String username, String password, String email, String gender, int flag, int role, String code) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.flag = flag;
		this.role = role;
		this.code = code;
	}
	public User() {
		super();
	}
	
}
