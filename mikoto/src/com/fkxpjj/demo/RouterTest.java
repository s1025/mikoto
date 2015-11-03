package com.fkxpjj.demo;

import java.util.List;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.module.passive.req.ReqText;
import com.s1025.kuroko.module.router.Reply;
import com.s1025.kuroko.module.router.Router;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class RouterTest {
	public static void main(String[] args){
		Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		DBConfig dbc = DBConfig.get();

		dbc.setUrl("jdbc:mysql://127.0.0.1:3306/kuroko?characterEncoding=UTF-8");
		dbc.setUser("root");
		dbc.setPasswd("pjjclub209");
		
		Router router = new Router();
		router.init();
		
		ReqText text = new ReqText();
		text.setMsgType("text");
		text.setCreateTime(111111);
		text.setFromUserName("fkx");
		text.setToUserName("s1025");
		text.setContent("tk0");
		text.setMsgId("1234");
		
		List<Reply> replys = router.mate(text);
		System.out.println(replys);
		
	}
}
