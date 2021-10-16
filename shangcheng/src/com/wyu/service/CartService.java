package com.wyu.service;

import java.util.List;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Cart;

public interface CartService {
	//1.��ӹ��ﳵ
	public boolean add(Cart cart);
	//2.��ȡ���û��Ĺ��ﳵ��Ϣ
	public List<BuyGoods> getAll(int uid);
	//3.�޸Ĺ��ﳵ
	public boolean update(Cart cart);
	//4.ɾ�����ﳵ�е�ָ����Ʒ
	public boolean delete(int uid,int pid);
}
