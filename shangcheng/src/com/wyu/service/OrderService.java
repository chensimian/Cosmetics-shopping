package com.wyu.service;

import java.util.List;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Order;

public interface OrderService {
	//1.���ɶ���
	public boolean addOrder(Order order,List<BuyGoods> list);
	//2.��ȡָ���û��Ķ����б�
	public List<Order> getOrderList(int uid);
	//3.���ݶ������  ��ȡһ������
	public Order getSingle(String oid);
	//4.��ȡ������ϸ��Ϣ
	public List<BuyGoods> getOrderDetail(String oid);
	//5.�޸Ķ���״̬
	public boolean changeOrderState(String oid);
	
	//6.��̨ ������ж�����Ϣ
	public List<Order> getAllOrder();
}
