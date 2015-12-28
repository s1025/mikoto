package com.fkxpjj.demo;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.module.passive.Parse;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.api.UserApi;
import com.s1025.mikoto.model.App;

public class RespTest {
	public static void main(String[] args){
		Init.init();
		
		int s = Kuroko.ks.messageKs.sendText("oVW-oszd62QE_kT66ilsRuuOJspA","admin", "hi");
		
		
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
