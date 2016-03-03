package com.s1025.kuroko.dao;

import java.util.List;

import com.s1025.kuroko.model.Account;

public interface AccountDAO {
	public int insert(Account account);
	public int delete(int id);
	public Account select(int id);
	public int update(Account account);
	
	public Account select(String account);
	public List<Account> select();
}
