package com.s1025.kuroko.dao;

import com.s1025.kuroko.model.NewsArticle;

public interface ArticleDAO {
	public int insert(NewsArticle na);
	public int delete(int naid);
	public NewsArticle select(int naid);
	public int update(NewsArticle na);
	public int truncate();
}
