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
import com.s1025.mikoto.util.Dev;

public class NewsTest {
	public static void main (String[] args){
		Init.init2();
		sendmass();
	}
	
	public static void get(){
		Gson gson = new Gson();
		
		String re = Mikoto.api.material.materialList("news", 0, 2);
		
		List<NewsArticle> rlna = new ArrayList<NewsArticle>();
		NewsBatch nb = gson.fromJson(re, NewsBatch.class);
		List<NewsItem> lni = nb.getItem();
		for(NewsItem ni:lni){
			NewsContent nc = ni.getContent();
			List<NewsArticle> lna = nc.getNews_item();
			for(int i = 0; i<lna.size(); i++){
				NewsArticle na = lna.get(i);
				na.setMedia_id(ni.getMedia_id());
				na.setNum(i+1);
				rlna.add(na);
			}
		}
		
		
	}
	
	public static void add(){
		NewsBuilder nb = new NewsBuilder();
		for(int i=3; i>0; i--){
			NewsArticle a = new NewsArticle();
			a.setTitle("b"+i);
			//a.setAuthor("f");
			a.setThumb_media_id("UFAuIan48n9bY_wbqR0kfgzwDTtt-xcpsWuss0k4b5w");
			a.setContent("ccccc"+i);
			//a.setDigest("d"+i);
			//a.setShow_cover_pic(1);
			//a.setContent_source_url("http://www.baidu.com");
			nb.add(a);
		}
		
		int i = Kuroko.ks.mediaKs.addNews(nb.getNews());
		
		System.out.println(i);
	}
	
	public static void sync(){
		Kuroko.ks.mediaKs.syncNews();
	}
	
	public static void sendmass(){
		String s = Mikoto.api.mass.preview("oVW-oszd62QE_kT66ilsRuuOJspA", "text", "aaaaa");
		System.out.println(s);
	}
}
