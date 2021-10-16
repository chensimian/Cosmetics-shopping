package com.wyu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wyu.bean.BuyGoods;
import com.wyu.bean.Goods;
import com.wyu.bean.Order;
import com.wyu.dao.OrderDao;
import com.wyu.utils.C3P0Utils;


public class OrderDaoImpl implements OrderDao{
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public boolean addOrder(Order order, List<BuyGoods> list) {
		/*
		 * 订单生成 需要实现的步骤
		 * 1.清空用户的购物车 cart delete --->uid
		 * 2.添加订单信息 order insert --> order对象中的信息
		 * 3.添加订单详细信息 orderDetail insert order.getId / List<BuyGoods> list
		 * 
		 * 因为需要一次执行三条sql语句 需要使用手动提交事务的功能
		 * 事务:
		 * 	1.开启事务 将事务的提交方式 从默认的自动提交 设置为手动提交
		 *  2.commit() 提交
		 *  3.rollback() 回滚
		 * */
		//创建一个Map集合 存储需要执行的sql 语句
		Map<Object[], String> map = new LinkedHashMap<>();
		//1.删除购物车
		map.put(new Object[]{order.getUid()}, "delete from tb_cart where id=?");
		//2.添加订单表
		map.put(new Object[]{order.getId(),order.getUid(),order.getMoney(),order.getStatus(),order.getAid()}, 
				"insert into tb_order(id,uid,money,status,time,aid) values(?,?,?,?,now(),?)");
		//3.添加订单详细信息表
		for(BuyGoods bg : list){
			map.put(new Object[]{order.getId(),bg.getGoods().getId(),bg.getNum(),bg.getMoney()}, 
					"insert into tb_orderdetail(oid,pid,num,money) values(?,?,?,?)");
		}
		
		return updateTranaction(map);
	}
	private static boolean updateTranaction(Map<Object[], String> map){
		Connection conn = null;
		boolean res = false;
		try {
			conn = C3P0Utils.getConnection();
			conn.setAutoCommit(false);//设置事务的提交方式为手动
			QueryRunner qrun = new QueryRunner();
			//获取map集合中的key  和 value 执行update 方法
			for(Object[] vs : map.keySet()){
				qrun.update(conn, map.get(vs), vs);
			}
			//提交事务
			conn.commit();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return res;
	}
	@Override
	public List<Order> getOrderList(int uid) {
		String sql = "select o.*,a.detail address from tb_order o,tb_address a where o.aid = a.id and o.uid=?";
		try {
			List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
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
	public Order getSingle(String oid) {
		String sql = "select * from tb_order where id=?";
		try {
			Order order = qr.query(sql, new BeanHandler<Order>(Order.class),oid);
			if(order!=null){
				return order;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<BuyGoods> getOrderDetail(String oid) {
		String sql = "select g.*,o.num,o.money from tb_orderdetail o join tb_goods g on o.pid=g.id where o.oid=?";
		try {
			return qr.query(sql, new ResultSetHandler<List<BuyGoods>>(){

				@Override
				public List<BuyGoods> handle(ResultSet rs) throws SQLException {
					List<BuyGoods> list = new ArrayList<>();
					while(rs.next()){
						list.add(new BuyGoods(rs.getInt("num"), rs.getInt("money"), 
								new Goods(rs.getInt("id"), rs.getString("name"), 
									rs.getString("pubdate"), rs.getString("picture"), 
									rs.getInt("price"), rs.getInt("star"), 
									rs.getString("intro"), rs.getInt("typeid"), 
									"")));
					}
					return list;
				}
				
			},oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean changeOrderState(String oid) {
		String sql = "update tb_order set status=status+1 where id=?";
		try {
			int res = qr.update(sql,oid);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Order> getAllOrder() {
		String sql ="select o.*,u.username username from tb_order o,tb_user u where o.uid=u.id order by o.time desc,o.status asc";
		try {
			List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class));
			if(list!=null)
				return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

















