package com.fkxpjj.demo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.s1025.kuroko.util.Parse;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.active.ArticleKf;
import com.s1025.mikoto.model.active.ArticleMaterial;
import com.s1025.mikoto.model.resp.RespArticle;
import com.s1025.mikoto.model.resp.RespNews;
import com.s1025.mikoto.util.Dev;

public class NewsTest {
	public static void main (String[] args){
		Mikoto.build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		/*
		Parse parse = new Parse();
		ArticleKf a1 = new ArticleKf();
		RespNews news = new RespNews();
		List<ArticleKf> list = new ArrayList<ArticleKf>();
		
		a1.setTitle("this is a1");
		a1.setDescription("a1 des");
		a1.setPicurl("22");
		a1.setUrl("http://baidu.com");
		
		for(int i=0; i<5; i++){
			ArticleKf a = new ArticleKf();
			a.setTitle("this is a "+i);
			a.setDescription(i+" des");
			a.setPicurl("http://mmbiz.qpic.cn/mmbiz/CedLmsO1IMFh5cJ42qy7XxEZc9lGB0c2ktuXUmq5AibyJibbiay3dXicq4pDuwdnnOiaV21lPstnwr1dIPUM9RXd2Pg/0");
			a.setUrl("http://www.baidu.com");
			list.add(a);
		}
		
		//news.setArticles(list);
		//news.setMsgType("news");
		
		//String xml = parse.RespToXML(news);
		//System.out.println(xml);
		
		String json = Mikoto.api.kf.sendCustomNews("oVW-oszd62QE_kT66ilsRuuOJspA", list);
		System.out.println(json);
		*/
		List<ArticleMaterial> list = new ArrayList<ArticleMaterial>();
		for(int i=0; i<1; i++){
			ArticleMaterial a = new ArticleMaterial();
			a.setTitle("a"+i);
			a.setAuthor("f");
			a.setThumb_media_id("UFAuIan48n9bY_wbqR0kfgzwDTtt-xcpsWuss0k4b5w");
			a.setContent("ccccc"+i);
			a.setDigest("d"+i);
			a.setShow_cover_pic("0");
			a.setContent_source_url("http://www.baidu.com");
			list.add(a);
		}
		String path = "d://1.jpg";
		String json = Mikoto.api.material.addNews(list);
		System.out.println(json);
	}
}
