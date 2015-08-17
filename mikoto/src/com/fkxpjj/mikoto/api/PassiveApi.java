package com.fkxpjj.mikoto.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.MsgType;
import com.fkxpjj.mikoto.model.req.ReqBase;
import com.fkxpjj.mikoto.model.req.ReqText;
import com.fkxpjj.mikoto.model.resp.Media;
import com.fkxpjj.mikoto.model.resp.MediaMusic;
import com.fkxpjj.mikoto.model.resp.MediaVideo;
import com.fkxpjj.mikoto.model.resp.RespArticle;
import com.fkxpjj.mikoto.model.resp.RespImg;
import com.fkxpjj.mikoto.model.resp.RespMusic;
import com.fkxpjj.mikoto.model.resp.RespNews;
import com.fkxpjj.mikoto.model.resp.RespText;
import com.fkxpjj.mikoto.model.resp.RespVideo;
import com.fkxpjj.mikoto.model.resp.RespVoice;

public class PassiveApi {
	public RespText getRespText(ReqBase reqBase, String content){
		RespText respText = new RespText();
		respText.setFromUserName(reqBase.getToUserName());
		respText.setToUserName(reqBase.getFromUserName());
		respText.setContent(content);
		respText.setMsgType(MsgType.TEXT);
		respText.setCreateTime(System.currentTimeMillis());
		return respText;
	}
	
	public RespImg getRespImg(ReqBase reqBase, String mediaId){
		RespImg respImg = new RespImg();
		Media image = new Media();
		respImg.setFromUserName(reqBase.getToUserName());
		respImg.setToUserName(reqBase.getFromUserName());
		respImg.setMsgType(MsgType.IMAGE);
		respImg.setCreateTime(System.currentTimeMillis());
		image.setMediaId(mediaId);
		respImg.setImage(image);
		return respImg;
	}
	
	public RespVoice getRespVoice(ReqBase reqBase, String mediaId){
		RespVoice respVoice = new RespVoice();
		Media voice = new Media();
		respVoice.setFromUserName(reqBase.getToUserName());
		respVoice.setToUserName(reqBase.getFromUserName());
		respVoice.setMsgType(MsgType.VOICE);
		respVoice.setCreateTime(System.currentTimeMillis());
		voice.setMediaId(mediaId);
		respVoice.setVoice(voice);
		return respVoice;
	}
	
	public RespVideo getRespVideo(ReqBase reqBase, String mediaId, String title, String desc){
		RespVideo respVideo = new RespVideo();
		MediaVideo video = new MediaVideo();
		respVideo.setFromUserName(reqBase.getToUserName());
		respVideo.setToUserName(reqBase.getFromUserName());
		respVideo.setMsgType(MsgType.VIDEO);
		respVideo.setCreateTime(System.currentTimeMillis());
		video.setTitle(title);
		video.setDescription(desc);
		video.setMediaId(mediaId);
		respVideo.setVideo(video);
		return respVideo;
	}
	
	public RespMusic getRespMusic(ReqBase reqBase, String title, String description, String musicUrl, String hQMusicUrl, String thumbMediaId){
		RespMusic respMusic = new RespMusic();
		MediaMusic music = new MediaMusic();
		respMusic.setFromUserName(reqBase.getToUserName());
		respMusic.setToUserName(reqBase.getFromUserName());
		respMusic.setMsgType(MsgType.MUSIC);
		respMusic.setCreateTime(System.currentTimeMillis());
		music.setTitle(title);
		music.setDescription(description);
		music.setMusicUrl(musicUrl);
		music.setHQMusicUrl(hQMusicUrl);
		music.setThumbMediaId(thumbMediaId);
		respMusic.setMusic(music);
		return respMusic;
	}
	
	public RespNews getRespNews(ReqBase reqBase, int count, List<RespArticle> articles){
		RespNews respNews = new RespNews();
		respNews.setFromUserName(reqBase.getToUserName());
		respNews.setToUserName(reqBase.getFromUserName());
		respNews.setMsgType(MsgType.NEWS);
		respNews.setCreateTime(System.currentTimeMillis());
		respNews.setArticleCount(count);
		respNews.setArticles(articles);
		return respNews;
	}
	
	public RespArticle getRespArticle(String title, String description, String picUrl, String url){
		RespArticle respArticle = new RespArticle();
		respArticle.setTitle(title);
		respArticle.setDescription(description);
		respArticle.setPicUrl(picUrl);
		respArticle.setUrl(url);
		return respArticle;
	}
	
	public void sendRespText(ReqText reqText, String content, HttpServletResponse resp) throws IOException{
		RespText respText = getRespText(reqText, content);
		String xml = Mikoto.parse.RespToXML(respText);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(xml);
		out.close();
	}
}
