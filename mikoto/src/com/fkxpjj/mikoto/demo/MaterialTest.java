package com.fkxpjj.mikoto.demo;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.Builder;

public class MaterialTest {
	public static void main(String[] args) throws Exception{
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String path="d://1.mp3";
		
		String s = Mikoto.api.material.addMaterial("voice", path);
		//String s = Mikoto.api.material.materialCount();
		System.out.println(s);
	}

}
