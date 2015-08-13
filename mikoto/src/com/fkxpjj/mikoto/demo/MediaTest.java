package com.fkxpjj.mikoto.demo;

import java.io.IOException;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.Builder;
import com.fkxpjj.mikoto.util.HttpCon;

public class MediaTest {
	public static void main (String[] args) throws IOException{
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String path = "D:\\1.jpg";
		
		String s = Mikoto.api.media.uploadMedia("image", path);
		System.out.println(s);
	}

}