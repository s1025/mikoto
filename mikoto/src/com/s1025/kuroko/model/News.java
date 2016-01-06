package com.s1025.kuroko.model;

import java.util.List;

public class News {
	private List<NewsArticle> articles;

	public List<NewsArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<NewsArticle> articles) {
		this.articles = articles;
	}
}
