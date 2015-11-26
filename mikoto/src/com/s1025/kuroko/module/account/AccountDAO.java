package com.s1025.kuroko.module.account;

import java.util.List;

public interface AccountDAO {
	public int insert(Account account);
	public int delete(String uid);
	public Account select(String uid);
	public int update(Account account);
	public List<Account> selectAll();
	
	public String selectPeopleUid(String openid);
}
