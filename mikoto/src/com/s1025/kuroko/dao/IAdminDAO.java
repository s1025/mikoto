package com.s1025.kuroko.dao;

import com.s1025.kuroko.model.Admin;

public interface IAdminDAO {
	public int insert(Admin admin);
	public Admin select(String aid);
	public int delete(String aid);
	public int update(Admin admin);
}
