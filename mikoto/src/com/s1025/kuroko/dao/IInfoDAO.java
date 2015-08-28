package com.s1025.kuroko.dao;

import com.s1025.kuroko.model.Info;

public interface IInfoDAO {
	public int insert(Info info);
	public Info select(int iid);
	public int update(Info info);
	public int delete(int iid);
}
