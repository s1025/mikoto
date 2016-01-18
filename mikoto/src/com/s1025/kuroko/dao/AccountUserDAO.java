package com.s1025.kuroko.dao;

import com.s1025.kuroko.model.AccountUser;

public interface AccountUserDAO {
	public int insert(AccountUser accountUser);
	public int delete(int id, String openid);
	public AccountUser select(int id, String openid);
	public int update(AccountUser accountUser);
	
	public int delete(int id);
}
