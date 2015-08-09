package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.api.KfApi;
import com.fkxpjj.mikoto.api.UserApi;
import com.fkxpjj.mikoto.model.RespText;
import com.fkxpjj.mikoto.util.Builder;
import com.fkxpjj.mikoto.util.Parse;

public class RespTest {
	public static void main(String[] args){
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");

		
		String s = Mikoto.api.kf.sendCustom("oVW-oszd62QE_kT66ilsRuuOJspA", "text", "hello");
		
		
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
