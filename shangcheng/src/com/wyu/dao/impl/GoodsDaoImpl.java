package com.wyu.dao.impl;

import com.wyu.bean.Goods;
import com.wyu.bean.GoodsType;
import com.wyu.dao.GoodsDao;
import com.wyu.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao{
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public List<GoodsType> getGoodsTypeList() {
		String sql = "SELECT gta.*,gtb.name parentName FROM tb_goods_type gta LEFT JOIN tb_goods_type gtb ON gta.parent = gtb.id";
		try {
			List<GoodsType> list = qr.query(sql, new BeanListHandler<GoodsType>(GoodsType.class));
			if(list!=null){
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Integer getGoodsTypeLevel(int id) {
		String sql = "SELECT LEVEL FROM tb_goods_type WHERE id=?";
		try {
			Integer level = (Integer)qr.query(sql, new ScalarHandler("level"),id);
			return level;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addGoodsType(GoodsType gt) {
		String sql = "insert into tb_goods_type(name,level,parent) values(?,?,?)";
		try {
			int res = qr.update(sql, gt.getName(),gt.getLevel(),gt.getParent());
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Goods> getGoodsList() {
		String sql = "select tb_goods_type.name as typeName,tb_goods.* from tb_goods,tb_goods_type where tb_goods_type.id = tb_goods.typeid";
		try {
			List<Goods> list = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
			if(list!=null)
				return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addGoods(Goods goods) {
		String d = goods.getPubdate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(d);
			String sql = "insert into tb_goods(name,pubdate,picture,price,star,intro,typeid) values(?,?,?,?,?,?,?)";
			int res = qr.update(sql, goods.getName(),new java.sql.Date(date.getTime()),goods.getPicture(),goods.getPrice(),goods.getStar(),goods.getIntro(),goods.getTypeid());
			if(res>0)
				return true;
		} catch (ParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<GoodsType> getGoodsTypeAjax() {
		try {
			List<GoodsType> list = qr.query("select * from tb_goods_type where level=1 limit 0,4", new BeanListHandler<GoodsType>(GoodsType.class));
			if(list!=null)
				return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Goods> getGoodsListByTypeId(int typeid) {
		String sql = "select tg.*,tgt.name typeName from tb_goods tg,tb_goods_type tgt where tg.typeid = tgt.id";
		if(typeid>0){
			sql += " and tg.typeid="+typeid;
		}
		try {
			List<Goods> list = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Goods getGoodsById(int goodsid) {
		String sql = "select tg.*,tgt.name typeName from tb_goods tg,tb_goods_type tgt where tg.typeid = tgt.id and tg.id=?";
		try {
			Goods goods = qr.query(sql, new BeanHandler<Goods>(Goods.class),goodsid);
			return goods;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
