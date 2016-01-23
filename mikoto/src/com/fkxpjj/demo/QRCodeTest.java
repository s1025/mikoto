package com.fkxpjj.demo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.NewsBuilder;
import com.s1025.kuroko.model.NewsArticle;
import com.s1025.kuroko.model.NewsBatch;
import com.s1025.kuroko.model.NewsContent;
import com.s1025.kuroko.model.NewsItem;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.model.active.ArticleKf;
import com.s1025.mikoto.util.Dev;

public class QRCodeTest {
	public static void main (String[] args){
		Init.init();
		String s = Mikoto.api.qrcode.createQRCode(300, 5);
		System.out.println(s);
	}
	
	
}
