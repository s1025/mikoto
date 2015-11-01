package com.fkxpjj.demo;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.module.Result;
import com.s1025.kuroko.module.user.Group;
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
		DB.init();
		UserService s = new UserService();
		Result<User> rs = s.getPageUsers(2, 2);
		System.out.println(rs);
		//boolean rs = s.syncAllUsers();
		//System.out.println(rs);
		//s.getAllGroup();
	}
}
