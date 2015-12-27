package com.fkxpjj.demo;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class Init {
	public static void init(){
		Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		//String s = Mikoto.api.group.getGroup();
		//System.out.println(s);
		DBConfig dbc = DBConfig.get();

		dbc.setUrl("jdbc:mysql://127.0.0.1:3306/kuroko?characterEncoding=UTF-8");
		dbc.setUser("root");
		dbc.setPasswd("pjjclub209");
		DB.init();
	}
}
