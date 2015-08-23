package com.fkxpjj.demo;

import com.s1025.kuroko.dao.IAdminDAO;
import com.s1025.kuroko.dao.impl.AdminDAOimpl;
import com.s1025.kuroko.model.Admin;

public class DAOTest {

	public static void main(String[] args) {
		IAdminDAO adminDAO = new AdminDAOimpl();
		Admin admin = new Admin();/*
		admin.setAid("fkxpjj");
		admin.setPasswd("123456");
		admin.setName("f");
		admin.setLv(1);
		admin.setStatus(1);
		admin.setOpenid("hahaha");
		admin.setEmail("hmail");
		int re = adminDAO.insert(admin);*/
		admin = adminDAO.select("fkxpjj");
		System.out.println(admin);
	}

}
