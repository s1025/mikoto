package com.fkxpjj.demo;

import java.util.List;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.ks.UserKs;
import com.s1025.kuroko.ks.impl.UserKsImpl;
import com.s1025.kuroko.model.Group;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class UserTest {
	public static void main(String[] args){
		Init.init();
		
		System.out.println(Kuroko.ks.userKs.pullUser("oVW-oszd62QE_kT66ilsRuuOJspA", true));
		//System.out.println(Kuroko.ks.userKs.changeUserGroup("oVW-oszd62QE_kT66ilsRuuOJspA", 118));
		//boolean rs = s.syncAllUsers();
		//System.out.println(rs);
		//s.getAllGroup();
	}
}
