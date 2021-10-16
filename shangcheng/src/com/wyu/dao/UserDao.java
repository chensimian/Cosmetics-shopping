package com.wyu.dao;

import com.wyu.bean.Address;
import com.wyu.bean.User;

import java.util.List;

public interface UserDao {
	public boolean addUser(User user);
	public boolean activate(String email,String code);
	public User checkName(String username);

	public List<Address> getAddressList(int uid);

	public boolean addAddress(Address add);

	public boolean deleteAddress(int aid);

	public boolean updateAddress(Address address);

	public boolean defaultAddress(int addressId,int level);
	

	public User findAdmin(String username);

	public List<User> getUserList();

	public boolean deleteUser(int id);

	public List<User> searchUser(String username,String gender);

	public Address getSingle(int aid);
}
