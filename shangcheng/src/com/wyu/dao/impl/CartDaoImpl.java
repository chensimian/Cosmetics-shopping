package com.wyu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Cart;
import com.wyu.bean.Goods;
import com.wyu.dao.CartDao;
import com.wyu.utils.C3P0Utils;

public class CartDaoImpl implements CartDao{
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public boolean add(Cart cart) {
		/*
		 * 添加购物车 分为两种情况
		 * 1.第一次添加 insert into
		 * 2.第N次添加 update 数量+1 价格=原有价格+新的价格
		 * 		先查询tb_cart 表中是否已经有该条记录
		 * */
		try {
			Cart c = qr.query("select * from tb_cart where id=? and pid=?", new BeanHandler<Cart>(Cart.class),cart.getUid(),cart.getPid());
			int i = 0;
			if(c == null){
				i = qr.update("insert into tb_cart(id,pid,num,money) values(?,?,?,?)",new Object[]{cart.getUid(),cart.getPid(),cart.getNum(),cart.getMoney()});
			}else{
				i = qr.update("update tb_cart set num=num+1,money=? where id=? and pid=?",c.getMoney()+cart.getMoney(),cart.getUid(),cart.getPid());
			}
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<BuyGoods> getAll(int uid) {
		String sql ="select g.*,c.num,c.money from tb_cart c join tb_goods g on g.id = c.pid where c.id=?";
		try {
			List<BuyGoods> list = qr.query(sql, new ResultSetHandler<List<BuyGoods>>(){

				@Override
				public List<BuyGoods> handle(ResultSet rs) throws SQLException {
					List<BuyGoods> list = new ArrayList<>();
					while(rs.next()){
						list.add(new BuyGoods(rs.getInt("num"), rs.getInt("money"), 
									new Goods(rs.getInt("id"), rs.getString("name"), rs.getString("pubdate"), 
										rs.getString("picture"), rs.getInt("price"), rs.getInt("star"),
										rs.getString("intro"), rs.getInt("typeid"), "")
											)
								);
					}
					return list;
				}
				
			},uid);
			if(list!=null)
				return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean update(Cart cart) {
		String sql = "update tb_cart set num=num+?,money=money+? where id=? and pid=?";
		try {
			int res = qr.update(sql, cart.getNum(),cart.getNum()>0?cart.getMoney():-cart.getMoney(),cart.getUid(),cart.getPid());
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delete(int uid, int pid) {
		//根据pid 的值 是0 还是 不是0 来区分 是删除一条 还是删除多条
		String sql = "delete from tb_cart where id=?";
		if(pid>0){
			sql+=" and pid="+pid;
		}
		try {
			int res = qr.update(sql,uid);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
