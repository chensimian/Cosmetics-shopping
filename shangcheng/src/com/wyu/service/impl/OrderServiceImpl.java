package com.wyu.service.impl;

import java.util.List;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Order;
import com.wyu.dao.OrderDao;
import com.wyu.dao.impl.OrderDaoImpl;
import com.wyu.service.OrderService;

public class OrderServiceImpl implements OrderService{
	OrderDao dao = new OrderDaoImpl();
	@Override
	public boolean addOrder(Order order, List<BuyGoods> list) {
		// TODO Auto-generated method stub
		return dao.addOrder(order, list);
	}
	@Override
	public List<Order> getOrderList(int uid) {
		// TODO Auto-generated method stub
		return dao.getOrderList(uid);
	}
	@Override
	public Order getSingle(String oid) {
		// TODO Auto-generated method stub
		return dao.getSingle(oid);
	}
	@Override
	public List<BuyGoods> getOrderDetail(String oid) {
		// TODO Auto-generated method stub
		return dao.getOrderDetail(oid);
	}
	@Override
	public boolean changeOrderState(String oid) {
		// TODO Auto-generated method stub
		return dao.changeOrderState(oid);
	}
	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return dao.getAllOrder();
	}

}
