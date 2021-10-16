package com.wyu.dao;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Order;

import java.util.List;

public interface OrderDao {
	//1.生成订单
		public boolean addOrder(Order order,List<BuyGoods> list);
	//2.获取指定用户的订单列表
		public List<Order> getOrderList(int uid);
	//3.根据订单编号  获取一条订单
		public Order getSingle(String oid);
	//4.获取订单详细信息
		public List<BuyGoods> getOrderDetail(String oid);
	//5.修改订单状态
		public boolean changeOrderState(String oid);
	//6.后台 获得所有订单信息
		public List<Order> getAllOrder();
}
