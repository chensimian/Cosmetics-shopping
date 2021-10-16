package com.wyu.dao;

import com.wyu.bean.Goods;
import com.wyu.bean.GoodsType;

import java.util.List;

public interface GoodsDao {
	//1.获取商品分类列表
		public List<GoodsType> getGoodsTypeList();
	//2.根据id获取等级
		public Integer getGoodsTypeLevel(int id);
	//3.添加新的商品分类
		public boolean addGoodsType(GoodsType gt);
	//4.获取商品列表
		public List<Goods> getGoodsList();
	//5.添加商品
		public boolean addGoods(Goods goods);
	//前台
	//6.头部 显示 级别为1的商品分类名称
		public List<GoodsType> getGoodsTypeAjax();
	//7.根据商品分类id 获取商品列表
		public List<Goods> getGoodsListByTypeId(int typeid);
	//8.根据商品id 查询指定商品
		public Goods getGoodsById(int goodsid);
}
