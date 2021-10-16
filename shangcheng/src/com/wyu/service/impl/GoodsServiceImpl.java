package com.wyu.service.impl;

import java.util.List;

import com.wyu.bean.Goods;
import com.wyu.bean.GoodsType;
import com.wyu.dao.GoodsDao;
import com.wyu.dao.impl.GoodsDaoImpl;
import com.wyu.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	GoodsDao dao = new GoodsDaoImpl();
	@Override
	public List<GoodsType> getGoodsTypeList() {
		// TODO Auto-generated method stub
		return dao.getGoodsTypeList();
	}
	@Override
	public Integer getGoodsTypeLevel(int id) {
		// TODO Auto-generated method stub
		return dao.getGoodsTypeLevel(id);
	}
	@Override
	public boolean addGoodsType(GoodsType gt) {
		// TODO Auto-generated method stub
		return dao.addGoodsType(gt);
	}
	@Override
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return dao.getGoodsList();
	}
	@Override
	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.addGoods(goods);
	}
	@Override
	public List<GoodsType> getGoodsTypeAjax() {
		// TODO Auto-generated method stub
		return dao.getGoodsTypeAjax();
	}
	@Override
	public List<Goods> getGoodsListByTypeId(int typeid) {
		// TODO Auto-generated method stub
		return dao.getGoodsListByTypeId(typeid);
	}
	@Override
	public Goods getGoodsById(int goodsid) {
		// TODO Auto-generated method stub
		return dao.getGoodsById(goodsid);
	}

}
