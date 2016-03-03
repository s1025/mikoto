package com.s1025.kuroko.ks;

import java.util.List;


import com.s1025.kuroko.model.Group;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.User;


public interface UserKs {
	//创建分组
	public Result<Group> createGroup(String name, boolean r);
	public int createGroup(String name);
	//获取分组
	public Result<Group> getGroups(boolean r);
	public List<Group> getGroups();
	//更改分组名
	public Result<Group> changeGroupName(int id, String name, boolean r);
	public int changeGroupName(int id, String name);
	//更改用户分组
	public Result<Group> changeUserGroup(String openid, int groupid, boolean r);
	public int changeUserGroup(String openid, int groupid);
	//同步分组
	public Result<Group> syncGroups(boolean r);
	public Result<Group> deleteGroup(int id, boolean r);
	//删除分组
	public int deleteGroup(int id);
	public boolean syncGroups();
	//更改用户备注
	public Result<User> changeUserRemark(String openid, String remark, boolean r);
	public int changeUserRemark(String openid, String remark);
	//同步用户
	public Result<User> syncUser(String openid, boolean r);
	public boolean syncUser(String openid);
	//同步所有用户
	public Result<User> syncUsers(boolean r);
	public boolean syncUsers();
	//添加本地用户
	public Result<User> pullUser(String openid, boolean r);
	public boolean pullUser(String openid);
	//删除本地用户
	public Result<User> delUser(String openid, boolean r);
	public boolean delUser(String openid);
	//获得用户
	public Result<User> getUsers(int page, int num, boolean r);
	public List<User> getUsers(int page, int num);
	
	
}
