package com.fkxpjj.mikoto.demo;

import java.io.IOException;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.Builder;
import com.s1025.mikoto.util.HttpCon;

public class MediaTest {
	public static void main (String[] args) throws IOException{
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String path = "D:\\2.jpg";
		
		String s = Mikoto.api.media.uploadMedia("thumb", path);
		System.out.println(s);
	}

}
