package com.wyu.bean;

import java.util.List;

public class OrderDetail {
	//��Ŷ�����ϸ��Ϣ ʵ��
	//1.���� Order �� 
	//2.���� Address ��
	//3.���� Goods ��
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
