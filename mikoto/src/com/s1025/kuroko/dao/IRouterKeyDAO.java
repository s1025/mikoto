package com.s1025.kuroko.dao;

import com.s1025.kuroko.plugin.router.Key;

public interface IRouterKeyDAO {
	public int insert(Key key);
	public Key select(String rname, String content);
	public int update(Key key);
	public int delete(String rname, String content);

}
