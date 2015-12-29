package com.fkxpjj.demo;

import java.io.IOException;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.module.media.Media;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.util.Dev;
import com.s1025.mikoto.util.HttpCon;

public class MediaTest {
	public static void main (String[] args) throws IOException{
		Init.init();
		
		
		String path = "D:\\1.jpg";
		
		int s = Kuroko.ks.mediaKs.addImage("a", path);
		System.out.println(s);
	}

}
