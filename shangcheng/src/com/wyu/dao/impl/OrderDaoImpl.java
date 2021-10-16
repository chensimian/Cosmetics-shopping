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
		 * �������� ��Ҫʵ�ֵĲ���
		 * 1.����û��Ĺ��ﳵ cart delete --->uid
		 * 2.��Ӷ�����Ϣ order insert --> order�����е���Ϣ
		 * 3.��Ӷ�����ϸ��Ϣ orderDetail insert order.getId / List<BuyGoods> list
		 * 
		 * ��Ϊ��Ҫһ��ִ������sql��� ��Ҫʹ���ֶ��ύ����Ĺ���
		 * ����:
		 * 	1.�������� ��������ύ��ʽ ��Ĭ�ϵ��Զ��ύ ����Ϊ�ֶ��ύ
		 *  2.commit() �ύ
		 *  3.rollback() �ع�
		 * */
		//����һ��Map���� �洢��Ҫִ�е�sql ���
		Map<Object[], String> map = new LinkedHashMap<>();
		//1.ɾ�����ﳵ
		map.put(new Object[]{order.getUid()}, "delete from tb_cart where id=?");
		//2.��Ӷ�����
		map.put(new Object[]{order.getId(),order.getUid(),order.getMoney(),order.getStatus(),order.getAid()}, 
				"insert into tb_order(id,uid,money,status,time,aid) values(?,?,?,?,now(),?)");
		//3.��Ӷ�����ϸ��Ϣ��
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
			conn.setAutoCommit(false);//����������ύ��ʽΪ�ֶ�
			QueryRunner qrun = new QueryRunner();
			//��ȡmap�����е�key  �� value ִ��update ����
			for(Object[] vs : map.keySet()){
				qrun.update(conn, map.get(vs), vs);
			}
			//�ύ����
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

















