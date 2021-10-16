package com.wyu.service.impl;

import java.util.List;

import com.wyu.bean.Address;
import com.wyu.bean.User;
import com.wyu.dao.UserDao;
import com.wyu.dao.impl.UserDaoImpl;
import com.wyu.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao dao = new UserDaoImpl();
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}
	@Override
	public boolean activate(String email, String code) {
		// TODO Auto-generated method stub
		return dao.activate(email, code);
	}
	@Override
	public User checkName(String username) {
		// TODO Auto-generated method stub
		return dao.checkName(username);
	}
	@Override
	public List<Address> getAddressList(int uid) {
		// TODO Auto-generated method stub
		return dao.getAddressList(uid);
	}
	@Override
	public boolean addAddress(Address add) {
		// TODO Auto-generated method stub
		return dao.addAddress(add);
	}
	@Override
	public boolean deleteAddress(int aid) {
		// TODO Auto-generated method stub
		return dao.deleteAddress(aid);
	}
	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		return dao.updateAddress(address);
	}
	@Override
	public boolean defaultAddress(int addressId, int userId) {
		//��������
		//1.�ȸ���userid ��ѯaddress list���� ��ȡ������Ϣ �ٽ���Щ��Ϣ��level�ȼ�ȫ������Ϊ0
		List<Address> list = dao.getAddressList(userId);
		for(Address addr : list){
			dao.defaultAddress(addr.getId(), 0);
		}
		//2.����addressId ��ָ����һ����¼ level ����Ϊ1
		return dao.defaultAddress(addressId, 1);
	}
	@Override
	public User findAdmin(String username) {
		// TODO Auto-generated method stub
		return dao.findAdmin(username);
	}
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return dao.getUserList();
	}
	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return dao.deleteUser(id);
	}
	@Override
	public List<User> searchUser(String username, String gender) {
		// TODO Auto-generated method stub
		return dao.searchUser(username, gender);
	}
	@Override
	public Address getSingle(int aid) {
		// TODO Auto-generated method stub
		return dao.getSingle(aid);
	}

}
