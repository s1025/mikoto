package com.s1025.kuroko.ks;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.model.News;
import com.s1025.kuroko.model.NewsArticle;

public class NewsBuilder {
	private List<NewsArticle> articles = new ArrayList<NewsArticle>();
	
	public NewsBuilder add(NewsArticle na){
		if(articles.size()<8){
			articles.add(na);
		}
		return this;
	}
	
	public NewsBuilder addNews(String title, String thumb, String content, String content_source_url, String digest, String author, int show_cover_pic){
		NewsArticle na = new NewsArticle();
		na.setTitle(title);
		na.setThumb_media_id(thumb);
		na.setContent(content);
		na.setContent_source_url(content_source_url);
		na.setDigest(digest);
		na.setAuthor(author);
		na.setShow_cover_pic(show_cover_pic);
		add(na);
		return this;
	}
	
	public NewsBuilder addNews(String title, String thumb, String content){
		NewsArticle na = new NewsArticle();
		na.setTitle(title);
		na.setThumb_media_id(thumb);
		na.setContent(content);
		return this;
	}
	
	public News getNews(){
		News news = new News();
		news.setArticles(articles);
		return news;
	}
}
