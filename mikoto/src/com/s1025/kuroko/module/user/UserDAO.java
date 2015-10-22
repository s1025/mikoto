package com.s1025.kuroko.module.user;

import java.util.List;

public interface UserDAO {
	public int insert(User user);
	public int delete(String openid);
	public User select(String openid);
	public int update(User user);
	public int clean();
	public int insertOpenids(List<String> openids);
	public int selectGroupUserNum(int groupid);  //获取某一分组的用户数
	public int updateUserGroup(int groupid, int groupid2); //将某一分组的用户全部改为另一分组
}
