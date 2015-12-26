package com.fkxpjj.demo;

import java.util.List;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.ks.UserKs;
import com.s1025.kuroko.ks.impl.UserKsImpl;
import com.s1025.kuroko.model.Group;
import com.s1025.kuroko.module.Result;
import com.s1025.kuroko.module.user.User;
import com.s1025.kuroko.module.user.UserDAO;
import com.s1025.kuroko.module.user.UserDAOimpl;
import com.s1025.kuroko.module.user.UserService;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class UserTest {
	public static void main(String[] args){
		Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		//String s = Mikoto.api.group.getGroup();
		//System.out.println(s);
		DBConfig dbc = DBConfig.get();

		dbc.setUrl("jdbc:mysql://127.0.0.1:3306/kuroko?characterEncoding=UTF-8");
		dbc.setUser("root");
		dbc.setPasswd("pjjclub209");
		DB.init();
		UserKs u = new UserKsImpl();
		String l = u.getGroups(true).toString();
		System.out.println(l);
		//boolean rs = s.syncAllUsers();
		//System.out.println(rs);
		//s.getAllGroup();
	}
}
