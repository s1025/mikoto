package com.s1025.kuroko.ks.impl;

import com.google.gson.Gson;
import com.s1025.kuroko.ks.MediaKs;
import com.s1025.kuroko.model.Media;
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

}
