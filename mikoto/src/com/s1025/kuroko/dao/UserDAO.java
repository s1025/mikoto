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
	public int selectGroupUserNum(int groupid);  //��ȡĳһ������û���
	public int updateUsersGroup(int groupid, int groupid2); //��ĳһ������û�ȫ����Ϊ��һ����
	public int updateUserRemark(String openid, String remark);
	public List<User> selectGroupUsers(int groupid); //��ȡĳһ����������û�
	
	public List<User> selectPageUsers(int groupid, int offset, int rows); //��ҳ��ѯ
	
	public boolean check(String openid);
}
