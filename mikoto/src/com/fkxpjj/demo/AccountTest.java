package com.fkxpjj.demo;

import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.module.account.AccountService;
import com.s1025.kuroko.module.router.Router;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class AccountTest {

	public static void main(String[] args) {
		Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		DBConfig dbc = DBConfig.get();

		dbc.setUrl("jdbc:mysql://127.0.0.1:3306/kuroko?characterEncoding=UTF-8");
		dbc.setUser("root");
		dbc.setPasswd("pjjclub209");
		
		Router router = new Router();
		router.init();
		
		AccountService a = new AccountService();
		int re = a.getPeopleLevel("oVW-oszd62QE_kT66ilsRuuOJspA");
		System.out.println(re);

	}

}
