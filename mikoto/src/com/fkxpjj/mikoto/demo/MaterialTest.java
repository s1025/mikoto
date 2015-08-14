package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.Builder;

public class MaterialTest {
	public static void main(String[] args) throws Exception{
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String path="d://2.jpg";
		
		String s = Mikoto.api.material.materialCount();
		System.out.println(s);
	}

}
