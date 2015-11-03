package com.fkxpjj.demo;

import java.io.IOException;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.module.Result;
import com.s1025.kuroko.module.media.Media;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.util.Dev;
import com.s1025.mikoto.util.HttpCon;

public class MediaTest {
	public static void main (String[] args) throws IOException{
		Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		DBConfig dbc = DBConfig.get();

		dbc.setUrl("jdbc:mysql://127.0.0.1:3306/kuroko?characterEncoding=UTF-8");
		dbc.setUser("root");
		dbc.setPasswd("pjjclub209");
		
		
		String path = "D:\\1.mp3";
		
		Result<Media> s = Kuroko.service.media.addVoice("t", path);
		System.out.println(s);
	}

}
