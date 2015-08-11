package com.fkxpjj.mikoto.model;

import java.util.List;

public class RespNews extends RespBase{
	private int ArticleCount;
	private List<RespArticle> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<RespArticle> getArticles() {
		return Articles;
	}
	public void setArticles(List<RespArticle> articles) {
		Articles = articles;
	}
}
