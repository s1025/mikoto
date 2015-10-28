package com.s1025.kuroko.module.media;

import com.google.gson.Gson;
import com.s1025.kuroko.module.ErrResult;
import com.s1025.kuroko.module.KuUtil;
import com.s1025.kuroko.module.Result;
import com.s1025.mikoto.Mikoto;

public class MediaService {
	
	Gson gson = new Gson();
	MediaDAO mediaDAO = new MediaDAOimpl();
	
	/**
	 * 添加永久图片.
	 * 同步到数据库中。
	 * @param path
	 * @return
	 */
	public Result<Media> addImage(String name, String path){
		String re = Mikoto.api.material.addMaterial("image", path);
		if(KuUtil.isResultSuccess(re)){
			Media media = gson.fromJson(re, Media.class);
			media.setName(name);
			media.setTemp(0);
			media.setType("image");
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
	
	/**
	 * 添加永久缩略图.
	 * 同步到数据库中，和添加永久图片几乎一样。
	 * @param path
	 * @return
	 */
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
	}
	
	/**
	 * 添加永久语音.
	 * 同步到数据库中，和添加永久图片几乎一样。
	 * @param path
	 * @return
	 */
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
	
}
