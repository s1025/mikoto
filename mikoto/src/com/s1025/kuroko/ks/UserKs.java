package com.s1025.kuroko.ks;

import java.util.List;


import com.s1025.kuroko.model.Group;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.User;


public interface UserKs {
	//��������
	public Result<Group> createGroup(String name, boolean r);
	public int createGroup(String name);
	//��ȡ����
	public Result<Group> getGroups(boolean r);
	public List<Group> getGroups();
	//���ķ�����
	public Result<Group> changeGroupName(int id, String name, boolean r);
	public int changeGroupName(int id, String name);
	//�����û�����
	public Result<Group> changeUserGroup(String openid, int groupid, boolean r);
	public int changeUserGroup(String openid, int groupid);
	//ͬ������
	public Result<Group> syncGroups(boolean r);
	public Result<Group> deleteGroup(int id, boolean r);
	//ɾ������
	public int deleteGroup(int id);
	public boolean syncGroups();
	//�����û���ע
	public Result<User> changeUserRemark(String openid, String remark, boolean r);
	public int changeUserRemark(String openid, String remark);
	//ͬ���û�
	public Result<User> syncUser(String openid, boolean r);
	public boolean syncUser(String openid);
	//ͬ�������û�
	public Result<User> syncUsers(boolean r);
	public boolean syncUsers();
	//��ӱ����û�
	public Result<User> pullUser(String openid, boolean r);
	public boolean pullUser(String openid);
	//ɾ�������û�
	public Result<User> delUser(String openid, boolean r);
	public boolean delUser(String openid);
	//����û�
	public Result<User> getUsers(int page, int num, boolean r);
	public List<User> getUsers(int page, int num);
	
	
}
