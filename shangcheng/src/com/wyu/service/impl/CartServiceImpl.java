package com.wyu.service.impl;

import java.util.List;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Cart;
import com.wyu.dao.CartDao;
import com.wyu.dao.impl.CartDaoImpl;
import com.wyu.service.CartService;

public class CartServiceImpl implements CartService{
	CartDao dao = new CartDaoImpl();
	@Override
	public boolean add(Cart cart) {
		// TODO Auto-generated method stub
		return dao.add(cart);
	}
	@Override
	public List<BuyGoods> getAll(int uid) {
		// TODO Auto-generated method stub
		return dao.getAll(uid);
	}
	@Override
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		return dao.update(cart);
	}
	@Override
	public boolean delete(int uid, int pid) {
		// TODO Auto-generated method stub
		return dao.delete(uid, pid);
	}

}
