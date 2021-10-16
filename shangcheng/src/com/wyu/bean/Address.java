package com.wyu.bean;

public class Address {
	private int id;
	private String detail;
	private String name;
	private String phone;
	private int uid;
	private int level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Address(String detail, String name, String phone, int uid, int level) {
		super();
		this.detail = detail;
		this.name = name;
		this.phone = phone;
		this.uid = uid;
		this.level = level;
	}
	public Address() {
		super();
	}
	
}
