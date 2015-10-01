package com.fkxpjj.demo;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.Dev;

public class MaterialTest {
	public static void main(String[] args) throws Exception{
		Mikoto.build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String path="d://1.jpg";
		
		String s = Mikoto.api.material.addNewsImg(path);
		//String s = Mikoto.api.material.materialCount();
		System.out.println(s);
	}

}
