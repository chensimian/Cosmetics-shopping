package com.wyu.service;

import java.util.List;

import com.wyu.bean.Address;
import com.wyu.bean.User;

public interface UserService {
	//1.添加用户
	public boolean addUser(User user);
	//2.验证注册
	public boolean activate(String email,String code);
	//3.验证用户名是否已存在
	public User checkName(String username);
	//4.根据用户id 查询 地址列表
	public List<Address> getAddressList(int uid);
	//5.添加用户地址
	public boolean addAddress(Address add);
	//6.删除指定用户地址
	public boolean deleteAddress(int aid);
	//7.修改用户地址
	public boolean updateAddress(Address address);
	//8.修改指定地址 为 默认地址
	public boolean defaultAddress(int addressId,int userId);
	
	//后台
	//1.管理员登录
	public User findAdmin(String username);
	//2.查询用户列表
	public List<User> getUserList();
	//3.删除用户信息
	public boolean deleteUser(int id);
	//4.条件查询用户列表
	public List<User> searchUser(String username,String gender);
	
	//订单详情页 需要的地址信息查询
	public Address getSingle(int aid);
}
