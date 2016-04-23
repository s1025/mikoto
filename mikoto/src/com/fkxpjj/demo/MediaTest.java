package com.fkxpjj.demo;

import java.io.IOException;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.dao.MediaDAO;
import com.s1025.kuroko.dao.impl.MediaDAOimpl;
import com.s1025.kuroko.model.Media;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.util.Dev;
import com.s1025.mikoto.util.HttpCon;

public class MediaTest {
	public static void main (String[] args) throws IOException{
		Init.init();
		
		MediaDAO mediaDAO = new MediaDAOimpl();
		
		String path = "D:\\1.jpg";
		
		//int s = Kuroko.ks.mediaKs.addImage("a", path);
		
		String re = Mikoto.api.media.uploadMedia("image", path);
		System.out.println(re);
	}

}
