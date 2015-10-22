package com.s1025.kuroko.module.user;

import java.util.List;

public interface UserDAO {
	public int insert(User user);
	public int delete(String openid);
	public User select(String openid);
	public int update(User user);
	public int clean();
	public int insertOpenids(List<String> openids);
}
