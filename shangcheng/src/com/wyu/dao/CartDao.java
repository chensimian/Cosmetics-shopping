package com.wyu.dao;

import java.util.List;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Cart;

public interface CartDao {
	//1.添加购物车
	public boolean add(Cart cart);
	//2.获取该用户的购物车信息
	public List<BuyGoods> getAll(int uid);
	//3.修改购物车
	public boolean update(Cart cart);
	//4.删除购物车中的指定商品
	public boolean delete(int uid,int pid);
}
