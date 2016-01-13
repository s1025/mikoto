package com.fkxpjj.demo;

import java.util.List;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Result;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.api.UserApi;
import com.s1025.mikoto.model.App;

public class RespTest {
	public static void main(String[] args){
		Init.init();
		
		//Result<KfMessage> s = Kuroko.ks.messageKs.sendText("oVW-oszd62QE_kT66ilsRuuOJspA","admin", "hi", true);
		//List<Reply> s = Kuroko.ks.messageKs.matchRule("²é");
		int s = Kuroko.ks.messageKs.sendNews("oVW-oszd62QE_kT66ilsRuuOJspA","system", "UFAuIan48n9bY_wbqR0kfn_j8Ch-9Oa-OerT3lQ84lQ");
		System.out.println(s);
		
		
		
		/*
		RespText text = new RespText();
		text.setContent("aaa");
		text.setCreateTime("123456789");
		text.setFromUserName("fkxpjj");
		text.setToUserName("cn");
		text.setMsgType("text");
		 * 
		 * */
	}

}
