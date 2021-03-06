package com.s1025.kuroko.model.resp;

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
	@Override
	public String toString() {
		return "RespNews [ArticleCount=" + ArticleCount + ", Articles="
				+ Articles + ", toString()=" + super.toString() + "]";
	}
}
