package com.s1025.mikoto.builder;

import java.util.Map;

import com.s1025.mikoto.model.req.ReqImg;
import com.s1025.mikoto.model.req.ReqLink;
import com.s1025.mikoto.model.req.ReqLocation;
import com.s1025.mikoto.model.req.ReqShortVideo;
import com.s1025.mikoto.model.req.ReqSubscribe;
import com.s1025.mikoto.model.req.ReqText;
import com.s1025.mikoto.model.req.ReqVideo;
import com.s1025.mikoto.model.req.ReqVoice;

public class ReqBuilder {
	public ReqText XMLtoText( Map<String, String> map){
		ReqText text = new ReqText();
		text.setFromUserName(map.get("FromUserName"));
		text.setToUserName(map.get("ToUserName"));
		text.setMsgType(map.get("MsgType"));
		text.setMsgId(map.get("MsgId"));
		text.setCreateTime(Long.parseLong(map.get("CreateTime")));
		text.setContent(map.get("Content"));
		return text;
	}
	
	public ReqImg XMLtoImg(Map<String, String> map){
		ReqImg img = new ReqImg();
		img.setFromUserName(map.get("FromUserName"));
		img.setToUserName(map.get("ToUserName"));
		img.setMsgType(map.get("MsgType"));
		img.setMsgId(map.get("MsgId"));
		img.setCreateTime(Long.parseLong(map.get("CreateTime")));
		img.setMediaId(map.get("MediaId"));
		img.setPicUrl(map.get("PicUrl"));
		return img;
	}
	
	public ReqVoice XMLtoVoice(Map<String, String> map){
		ReqVoice reqVoice = new ReqVoice();
		reqVoice.setFromUserName(map.get("FromUserName"));
		reqVoice.setToUserName(map.get("ToUserName"));
		reqVoice.setMsgType(map.get("MsgType"));
		reqVoice.setMsgId(map.get("MsgId"));
		reqVoice.setCreateTime(Long.parseLong(map.get("CreateTime")));
		reqVoice.setMediaId(map.get("MediaId"));
		reqVoice.setFormat(map.get("Format"));
		return reqVoice;
	}
	
	public ReqVideo XMLtoVideo(Map<String, String> map){
		ReqVideo reqVideo = new ReqVideo();
		reqVideo.setFromUserName(map.get("FromUserName"));
		reqVideo.setToUserName(map.get("ToUserName"));
		reqVideo.setMsgType(map.get("MsgType"));
		reqVideo.setMsgId(map.get("MsgId"));
		reqVideo.setCreateTime(Long.parseLong(map.get("CreateTime")));
		reqVideo.setMediaId(map.get("MediaId"));
		reqVideo.setThumbMediaId(map.get("ThumbMediaId"));
		return reqVideo;
	}
	
	public ReqShortVideo XMLtoShortVideo(Map<String, String> map){
		ReqShortVideo reqVideo = new ReqShortVideo();
		reqVideo.setFromUserName(map.get("FromUserName"));
		reqVideo.setToUserName(map.get("ToUserName"));
		reqVideo.setMsgType(map.get("MsgType"));
		reqVideo.setMsgId(map.get("MsgId"));
		reqVideo.setCreateTime(Long.parseLong(map.get("CreateTime")));
		reqVideo.setMediaId(map.get("MediaId"));
		reqVideo.setThumbMediaId(map.get("ThumbMediaId"));
		return reqVideo;
	}
	
	public ReqLocation XMLtoLocation(Map<String, String> map){
		ReqLocation reqLocation = new ReqLocation();
		reqLocation.setFromUserName(map.get("FromUserName"));
		reqLocation.setToUserName(map.get("ToUserName"));
		reqLocation.setMsgType(map.get("MsgType"));
		reqLocation.setMsgId(map.get("MsgId"));
		reqLocation.setCreateTime(Long.parseLong(map.get("CreateTime")));
		reqLocation.setLocation_X(map.get("Location_X"));
		reqLocation.setLocation_Y(map.get("Location_Y"));
		reqLocation.setScale(map.get("Scale"));
		reqLocation.setLabel(map.get("Label"));
		return reqLocation;
	}
	
	public ReqLink XMLtoLink(Map<String, String> map){
		ReqLink reqLink = new ReqLink();
		reqLink.setFromUserName(map.get("FromUserName"));
		reqLink.setToUserName(map.get("ToUserName"));
		reqLink.setMsgType(map.get("MsgType"));
		reqLink.setMsgId(map.get("MsgId"));
		reqLink.setCreateTime(Long.parseLong(map.get("CreateTime")));
		reqLink.setTitle(map.get("Link"));
		reqLink.setDescription(map.get("Description"));
		reqLink.setUrl(map.get("Url"));
		return reqLink;
	}
	
	public ReqSubscribe XMLtoSubscribe(Map<String, String> map){
		ReqSubscribe reqSubscribe = new ReqSubscribe();
		reqSubscribe.setFromUserName(map.get("FromUserName"));
		reqSubscribe.setToUserName(map.get("ToUserName"));
		reqSubscribe.setMsgType(map.get("MsgType"));
		reqSubscribe.setCreateTime(Long.parseLong(map.get("CreateTime")));
		reqSubscribe.setEvent(map.get("Event"));
		return reqSubscribe;
	}
}
