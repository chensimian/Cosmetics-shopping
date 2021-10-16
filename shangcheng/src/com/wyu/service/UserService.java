package com.wyu.service;

import java.util.List;

import com.wyu.bean.Address;
import com.wyu.bean.User;

public interface UserService {
	//1.����û�
	public boolean addUser(User user);
	//2.��֤ע��
	public boolean activate(String email,String code);
	//3.��֤�û����Ƿ��Ѵ���
	public User checkName(String username);
	//4.�����û�id ��ѯ ��ַ�б�
	public List<Address> getAddressList(int uid);
	//5.����û���ַ
	public boolean addAddress(Address add);
	//6.ɾ��ָ���û���ַ
	public boolean deleteAddress(int aid);
	//7.�޸��û���ַ
	public boolean updateAddress(Address address);
	//8.�޸�ָ����ַ Ϊ Ĭ�ϵ�ַ
	public boolean defaultAddress(int addressId,int userId);
	
	//��̨
	//1.����Ա��¼
	public User findAdmin(String username);
	//2.��ѯ�û��б�
	public List<User> getUserList();
	//3.ɾ���û���Ϣ
	public boolean deleteUser(int id);
	//4.������ѯ�û��б�
	public List<User> searchUser(String username,String gender);
	
	//��������ҳ ��Ҫ�ĵ�ַ��Ϣ��ѯ
	public Address getSingle(int aid);
}
