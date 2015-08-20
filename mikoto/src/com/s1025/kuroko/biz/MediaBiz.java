package com.s1025.kuroko.biz;

import java.io.IOException;

import com.google.gson.Gson;
import com.s1025.kuroko.result.ErrCode;
import com.s1025.kuroko.result.MediaResult;
import com.s1025.kuroko.result.ResultBase;
import com.s1025.kuroko.result.ResultType;
import com.s1025.kuroko.result.ThumbMediaResult;
import com.s1025.mikoto.Mikoto;

public class MediaBiz {
	public static ResultBase uploadMedia(String path, boolean thumb) throws IOException{
		String end = path.substring(path.lastIndexOf(".")+1);
		String type = "";
		if(thumb){
			type = "thumb";
		} else if(end.endsWith("JPG")||end.endsWith("jpg")){
			type = "image";
		} else if(end.endsWith("amr")||end.endsWith("AMR")||end.endsWith("mp3")||end.endsWith("MP3")){
			type = "voice";
		} else if(end.endsWith("mp4")||end.endsWith("MP4")){
			type = "video";
		}
		String response = Mikoto.api.media.uploadMedia(type, path);
		Gson gson = new Gson();
		ErrCode err = gson.fromJson(response, ErrCode.class);
		MediaResult result = gson.fromJson(response, MediaResult.class);
		ThumbMediaResult tresult = gson.fromJson(response, ThumbMediaResult.class);
		System.out.println(response);
		if(tresult.getThumb_media_id()!=null){
			result.setType("thumb");
			result.setMedia_id(tresult.getThumb_media_id());
			result.setResultType(ResultType.MEDIA);
			result.setCreated_at(tresult.getCreated_at());
		}
		if(err.getErrcode()==null){
			result.setResultType(ResultType.MEDIA);
			return result;
		} else if(result.getMedia_id()==null){
			err.setResultType(ResultType.ERRCODE);
			return err;
		}
		
		return new ResultBase(ResultType.NONE);
	}
	
	public static ResultBase uploadMaterial(String path, boolean thumb) throws IOException{
		String end = path.substring(path.lastIndexOf(".")+1);
		String type = "";
		if(thumb){
			type = "thumb";
		} else if(end.endsWith("JPG")||end.endsWith("jpg")){
			type = "image";
		} else if(end.endsWith("amr")||end.endsWith("AMR")||end.endsWith("mp3")||end.endsWith("MP3")){
			type = "voice";
		} else if(end.endsWith("mp4")||end.endsWith("MP4")){
			type = "video";
		}
		String response = Mikoto.api.media.uploadMedia(type, path);
		Gson gson = new Gson();
		ErrCode err = gson.fromJson(response, ErrCode.class);
		MediaResult result = gson.fromJson(response, MediaResult.class);
		ThumbMediaResult tresult = gson.fromJson(response, ThumbMediaResult.class);
		System.out.println(response);
		if(tresult.getThumb_media_id()!=null){
			result.setType("thumb");
			result.setMedia_id(tresult.getThumb_media_id());
			result.setResultType(ResultType.MEDIA);
			result.setCreated_at(tresult.getCreated_at());
		}
		if(err.getErrcode()==null){
			result.setResultType(ResultType.MEDIA);
			return result;
		} else if(result.getMedia_id()==null){
			err.setResultType(ResultType.ERRCODE);
			return err;
		}
		
		return new ResultBase(ResultType.NONE);
	}
}
