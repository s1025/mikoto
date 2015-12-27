package com.fkxpjj.demo;

import java.util.List;

import com.s1025.kuroko.Kuroko;
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
		Init.init();
		
		System.out.println(Kuroko.ks.userKs.deleteGroup(117));
		//boolean rs = s.syncAllUsers();
		//System.out.println(rs);
		//s.getAllGroup();
	}
}
