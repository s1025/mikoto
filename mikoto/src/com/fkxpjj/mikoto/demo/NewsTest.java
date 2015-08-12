package com.fkxpjj.mikoto.demo;

import java.util.ArrayList;
import java.util.List;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.resp.RespArticle;
import com.fkxpjj.mikoto.model.resp.RespNews;
import com.fkxpjj.mikoto.util.Builder;
import com.fkxpjj.mikoto.util.Parse;
import com.google.gson.Gson;

public class NewsTest {
	public static void main (String[] args){
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		Parse parse = new Parse();
		RespArticle a1 = new RespArticle();
		RespNews news = new RespNews();
		List<RespArticle> list = new ArrayList<RespArticle>();
		
		a1.setTitle("this is a1");
		a1.setDescription("a1 des");
		a1.setPicUrl("11");
		a1.setUrl("http://baidu.com");
		
		for(int i=0; i<5; i++){
			RespArticle a = new RespArticle();
			a.setTitle("this is a "+i);
			a.setDescription(i+" des");
			a.setPicUrl("http://s0.hao123img.com/res/r/image/2015-08-10/ecc488824a4114f419c8ebc2520a2310.jpg");
			a.setUrl("http://www.baidu.com");
			list.add(a);
		}
		
		//news.setArticles(list);
		//news.setMsgType("news");
		
		//String xml = parse.RespToXML(news);
		//System.out.println(xml);
		
		String json = Mikoto.api.kf.sendCustomNews("oVW-oszd62QE_kT66ilsRuuOJspA", list);
		System.out.println(json);
	}
}
