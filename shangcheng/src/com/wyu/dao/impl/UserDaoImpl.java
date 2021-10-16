package com.wyu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wyu.bean.Address;
import com.wyu.bean.User;
import com.wyu.dao.UserDao;
import com.wyu.utils.C3P0Utils;

public class UserDaoImpl implements UserDao {
	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public boolean addUser(User user) {
		String sql = "insert into tb_user(username,password,email,gender,flag,role,code) values(?,?,?,?,?,?,?)";
		try {
			int res = qr.update(sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode());
			if(res>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean activate(String email, String code) {
		try {
			int res = qr.update("update tb_user set flag = 1 where email=? and code=?",email,code);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public User checkName(String username) {
		User user = null;
		try {
			user = qr.query("select * from tb_user where username=? and flag=1 and role=1", new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public List<Address> getAddressList(int uid) {
		String sql = "select * from tb_address where uid=? order by level desc,id desc";
		try {
			List<Address> list = qr.query(sql, new BeanListHandler<Address>(Address.class),uid);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addAddress(Address add) {
		String sql ="insert into tb_address(detail,name,phone,uid,level) values(?,?,?,?,?)";
		try {
			int res = qr.update(sql,add.getDetail(),add.getName(),add.getPhone(),add.getUid(),add.getLevel());
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deleteAddress(int aid) {
		String sql = "delete from tb_address where id=?";
		try {
			int res = qr.update(sql,aid);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean updateAddress(Address address) {
		String sql = "update tb_address set detail=?,name=?,phone=?,uid=?,level=? where id=?";
		try {
			int res = qr.update(sql, address.getDetail(),address.getName(),address.getPhone(),address.getUid(),address.getLevel(),address.getId());
			if(res>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean defaultAddress(int addressId, int level) {
		String sql = "update tb_address set level = ? where id = ?";
		try {
			int res = qr.update(sql,level,addressId);
			if(res>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public User findAdmin(String username) {
		User user = null;
		try {
			user = qr.query("select * from tb_user where username=? and flag=1 and role=0", new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public List<User> getUserList() {
		try {
			List<User> list = qr.query("select * from tb_user where flag=1", new BeanListHandler<User>(User.class));
			if(list!=null)
				return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean deleteUser(int id) {
		String sql = "update tb_user set flag=2 where id=?";
		try {
			int res = qr.update(sql,id);
			if(res>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<User> searchUser(String username, String gender) {
		String sql = "select * from tb_user where flag=1";
		if(!"".equals(username)){
			sql +=" and username like '%"+username+"%'";
		}
		if(!"".equals(gender)){
			sql +=" and gender='"+gender+"'";
		}
		try {
			List<User> list = qr.query(sql, new BeanListHandler<User>(User.class));
			if(list.size()>0){
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Address getSingle(int aid) {
		String sql = "select * from tb_address where id=?";
		try {
			Address address = qr.query(sql, new BeanHandler<Address>(Address.class),aid);
			if(address!=null){
				return address;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
