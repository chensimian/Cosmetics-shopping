package com.wyu.bean;

public class Cart {
	private int uid;//用户id
	private int pid;//商品id
	private int num;//数量
	private int money;//价格
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Cart(int uid, int pid, int num, int money) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.num = num;
		this.money = money;
	}
	public Cart() {
		super();
	}
	
}
