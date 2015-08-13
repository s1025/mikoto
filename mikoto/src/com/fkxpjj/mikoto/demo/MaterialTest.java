package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.Builder;

public class MaterialTest {
	public static void main(String[] args) throws Exception{
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String path="d://1.mp4";
		
		String s = Mikoto.api.material.addMaterialVideo(path, "vtest1", "vintro1");
		System.out.println(s);
	}

}
