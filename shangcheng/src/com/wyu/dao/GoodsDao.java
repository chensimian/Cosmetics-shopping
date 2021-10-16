package com.wyu.dao;

import com.wyu.bean.Goods;
import com.wyu.bean.GoodsType;

import java.util.List;

public interface GoodsDao {
	//1.��ȡ��Ʒ�����б�
		public List<GoodsType> getGoodsTypeList();
	//2.����id��ȡ�ȼ�
		public Integer getGoodsTypeLevel(int id);
	//3.����µ���Ʒ����
		public boolean addGoodsType(GoodsType gt);
	//4.��ȡ��Ʒ�б�
		public List<Goods> getGoodsList();
	//5.�����Ʒ
		public boolean addGoods(Goods goods);
	//ǰ̨
	//6.ͷ�� ��ʾ ����Ϊ1����Ʒ��������
		public List<GoodsType> getGoodsTypeAjax();
	//7.������Ʒ����id ��ȡ��Ʒ�б�
		public List<Goods> getGoodsListByTypeId(int typeid);
	//8.������Ʒid ��ѯָ����Ʒ
		public Goods getGoodsById(int goodsid);
}
