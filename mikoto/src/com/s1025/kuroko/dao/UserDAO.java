package com.s1025.kuroko.dao;

import java.util.List;

import com.s1025.kuroko.model.User;

public interface UserDAO {
	public int insert(User user);
	public int delete(String openid);
	public User select(String openid);
	public int update(User user);
	
	public int clean();
	public int insertOpenids(List<String> openids);
	public int selectGroupUserNum(int groupid);  //获取某一分组的用户数
	public int updateUsersGroup(int groupid, int groupid2); //将某一分组的用户全部改为另一分组
	public int updateUserRemark(String openid, String remark);
	public List<User> selectGroupUsers(int groupid); //获取某一分组的所有用户
	
	public List<User> selectPageUsers(int groupid, int offset, int rows); //分页查询
	
	public boolean check(String openid);
}
