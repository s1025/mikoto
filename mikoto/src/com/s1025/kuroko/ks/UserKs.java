package com.s1025.kuroko.ks;

import java.util.List;


import com.s1025.kuroko.model.Group;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.User;


public interface UserKs {
	
	public Result<Group> addGroup(String name);
	public Result<Group> delGroup(int id);
	public Result<Group> getGroups();
	public Result<Group> changeGroupName(int id, String name);
	public Result<Group> changeUserGroup(String openid, int groupid);
	public Result<Group> syncGroups();
	
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
	public Result<User> getUsers(int groupid, int page, int num);
	
	
}
