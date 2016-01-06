package com.s1025.kuroko.ks.impl;

import com.google.gson.Gson;
import com.s1025.kuroko.ks.MediaKs;
import com.s1025.kuroko.model.Media;
import com.s1025.kuroko.model.MediaCount;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.dao.MediaDAO;
import com.s1025.kuroko.dao.impl.MediaDAOimpl;
import com.s1025.mikoto.Mikoto;

public class MediaKsImpl implements MediaKs{
	
	Gson gson = new Gson();
	MediaDAO mediaDAO = new MediaDAOimpl();
	
	@Override
	public Result<Media> addImage(String name, String path, boolean r) {
		String re = Mikoto.api.material.addMaterial("image", path);
		if(KuUtil.isResultSuccess(re)){
			Media media = gson.fromJson(re, Media.class);
			media.setName(name);
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
	public int addImage(String name, String path) {
		Result<Media> rs = addImage(name, path, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	@Override
	public Result<MediaCount> getMediaCount(boolean r) {
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
	public MediaCount getMediaCount() {
		Result<MediaCount> rmc = getMediaCount(true);
		if(rmc.getErrcode()==0)
			return rmc.getData();
		return new MediaCount();
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
