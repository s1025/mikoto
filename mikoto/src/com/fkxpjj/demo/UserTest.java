package com.fkxpjj.demo;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.module.Result;
import com.s1025.kuroko.module.user.Group;
import com.s1025.kuroko.module.user.User;
import com.s1025.kuroko.module.user.UserDAO;
import com.s1025.kuroko.module.user.UserDAOimpl;
import com.s1025.kuroko.module.user.UserService;
import com.s1025.mikoto.Mikoto;

public class UserTest {
	public static void main(String[] args){
		Mikoto.build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		//String s = Mikoto.api.group.getGroup();
		//System.out.println(s);
		DB.init();
		UserService s = new UserService();
		//boolean rs = s.syncUser("oVW-os9UkORwWvVlp09R4hAaPCF4");
		UserDAO userDAO = new UserDAOimpl();
		boolean rs = s.syncUserIdList();
		System.out.println(rs);
	}
}
