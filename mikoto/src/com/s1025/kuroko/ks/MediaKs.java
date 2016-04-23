package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Media;
import com.s1025.kuroko.model.MediaCount;
import com.s1025.kuroko.model.News;
import com.s1025.kuroko.model.NewsArticle;

public interface MediaKs {
	public Result<Media> addImage(String path);
	
	public Result<Media> addNews(News news);
	
	//public Result<Media> addNews();
	
	public Result<MediaCount> getMediaCount();
	
	public String getMediaList(String type, int offset, int count);
	
	public Result<NewsArticle> syncNews();
	
	public Result<String> addImageTmp(String path);
}
