package com.wyu.bean;

import java.util.List;

public class OrderDetail {
	//存放订单详细信息 实体
	//1.包含 Order 表 
	//2.包含 Address 表
	//3.包含 Goods 表
	private Order order;
	private Address address;
	private List<BuyGoods> list;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<BuyGoods> getList() {
		return list;
	}
	public void setList(List<BuyGoods> list) {
		this.list = list;
	}
	public OrderDetail(Order order, Address address, List<BuyGoods> list) {
		super();
		this.order = order;
		this.address = address;
		this.list = list;
	}
	public OrderDetail() {
		super();
	}
	
	
}
