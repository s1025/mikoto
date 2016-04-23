package com.s1025.kuroko.ks.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.s1025.kuroko.ks.MediaKs;
import com.s1025.kuroko.model.Media;
import com.s1025.kuroko.model.MediaCount;
import com.s1025.kuroko.model.MediaTmp;
import com.s1025.kuroko.model.News;
import com.s1025.kuroko.model.NewsArticle;
import com.s1025.kuroko.model.NewsBatch;
import com.s1025.kuroko.model.NewsContent;
import com.s1025.kuroko.model.NewsItem;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.dao.ArticleDAO;
import com.s1025.kuroko.dao.MediaDAO;
import com.s1025.kuroko.dao.impl.ArticleDAOimpl;
import com.s1025.kuroko.dao.impl.MediaDAOimpl;
import com.s1025.mikoto.Mikoto;

public class MediaKsImpl implements MediaKs{
	
	Gson gson = new Gson();
	MediaDAO mediaDAO = new MediaDAOimpl();
	ArticleDAO articleDAO = new ArticleDAOimpl();
	
	@Override
	public Result<Media> addImage(String path) {
		String re = Mikoto.api.material.addMaterial("image", path);
		if(KuUtil.isResultSuccess(re)){
			Media media = gson.fromJson(re, Media.class);
			media.setTemp(0);
			media.setType("image");
			mediaDAO.insert(media);
			Result<Media> rs = new Result<Media>(0,"ok",media,null);
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Media> rs = new Result<Media>(er);
			return rs;
		}
	}

	@Override
	public Result<Media> addNews(News news) {
		Gson gson = new Gson();
		String re = Mikoto.api.material.addNews(gson.toJson(news));
		if(KuUtil.isResultSuccess(re)){
			Media media = gson.fromJson(re, Media.class);
			media.setTemp(0);
			media.setType("news");
			mediaDAO.insert(media);
			
			List<NewsArticle> lna = news.getArticles();
			for(int i=0; i<lna.size(); i++){
				lna.get(i).setMedia_id(media.getMedia_id());
				lna.get(i).setNum(i+1);
				articleDAO.insert(lna.get(i));
			}
			
			Result<Media> rs = new Result<Media>(0,"ok",media,null);
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Media> rs = new Result<Media>(er);
			return rs;
		}
	}
	
	@Override
	public Result<MediaCount> getMediaCount() {
		String re = Mikoto.api.material.materialCount();
		if(KuUtil.isResultSuccess(re)){
			MediaCount mc = gson.fromJson(re, MediaCount.class);
			Result<MediaCount> rs = new Result<MediaCount>(0,"ok",mc,null);
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<MediaCount> rs = new Result<MediaCount>(er);
			return rs;
		}
	}

	@Override
	public Result<NewsArticle> syncNews() {
		MediaCount mc = getMediaCount().getData();
		int newsNum = mc.getNews_count();
		List<NewsBatch> lnb = new ArrayList<NewsBatch>();
		
		articleDAO.truncate();
		
		for(int n=0;n<newsNum;n=n+20){
			String re = Mikoto.api.material.materialList("news", n, 20);
			if(KuUtil.isResultSuccess(re)){
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
						articleDAO.insert(na);
					}
				}
			} else {
				ErrResult er = gson.fromJson(re, ErrResult.class);
				Result<NewsArticle> rs = new Result<NewsArticle>(er);
				return rs;
			}
		}
		

		Result<NewsArticle> rs = new Result<NewsArticle>(0,"ok",null,null);
		return rs;
		
		
	}

	@Override
	public String getMediaList(String type, int offset, int count) {
		String re = Mikoto.api.material.materialList(type, offset, count);
		return null;
	}

	@Override
	public Result<String> addImageTmp(String path) {
		String re = Mikoto.api.material.addMaterial("image", path);
		if(KuUtil.isResultSuccess(re)){
			MediaTmp mediaTmp = gson.fromJson(re, MediaTmp.class);
			Result<String> rs = new Result<String>(0,"ok",mediaTmp.getMedia_id(),null);
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<String> rs = new Result<String>(er);
			return rs;
		}
	}

	

	
	  /**
	 * 添加永久缩略图.
	 * 同步到数据库中，和添加永久图片几乎一样。
	 * @param path
	 * @return
	 *//**
	public Result<Media> addThumb(String name, String path){
		String re = Mikoto.api.material.addMaterial("thumb", path);
		if(KuUtil.isResultSuccess(re)){
			Media media = gson.fromJson(re, Media.class);
			media.setName(name);
			media.setTemp(0);
			media.setType("thumb");
			mediaDAO.insert(media);
			Result<Media> r = new Result<Media>(media);
			r.setErrCode(0);
			r.setErrMsg("ok");
			return r;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Media> r = new Result<Media>(er);
			return r;
		}
	}**/
	
	/**
	 * 添加永久语音.
	 * 同步到数据库中，和添加永久图片几乎一样。
	 * @param path
	 * @return
	 *//**
	public Result<Media> addVoice(String name, String path){
		String re = Mikoto.api.material.addMaterial("voice", path);
		if(KuUtil.isResultSuccess(re)){
			Media media = gson.fromJson(re, Media.class);
			media.setName(name);
			media.setTemp(0);
			media.setType("voice");
			mediaDAO.insert(media);
			Result<Media> r = new Result<Media>(media);
			r.setErrCode(0);
			r.setErrMsg("ok");
			return r;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Media> r = new Result<Media>(er);
			return r;
		}
	}
	 **/
}
