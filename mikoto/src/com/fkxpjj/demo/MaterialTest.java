package com.fkxpjj.demo;

import com.google.gson.Gson;
import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.model.MediaCount;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.util.Dev;

public class MaterialTest {
	public static void main(String[] args) throws Exception{
		//Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		Init.init();
		String path="d://1.mp4";
		
		//Kuroko.service.media.addVideo(path);
		//String s = Mikoto.api.material.materialCount();
		String s = Mikoto.api.material.materialList("news", 0, 10);
		
		Gson gson = new Gson();
		//MediaCount mc =  gson.fromJson(s, MediaCount.class);
		
		System.out.println(s);
	}

}
