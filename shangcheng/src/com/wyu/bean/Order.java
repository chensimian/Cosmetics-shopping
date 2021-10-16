package com.wyu.bean;

public class Order {
	private String id;
	private int uid;
	private int money;
	private String status;
	private String time;
	private int aid;
	private String address;
	private String username;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Order(String id, int uid, int money, String status, String time, int aid) {
		super();
		this.id = id;
		this.uid = uid;
		this.money = money;
		this.status = status;
		this.time = time;
		this.aid = aid;
	}
	public Order() {
		super();
	}
	
}
