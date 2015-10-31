package com.s1025.kuroko.module.passive;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.module.passive.req.ReqBase;
import com.s1025.kuroko.module.passive.resp.Media;
import com.s1025.kuroko.module.passive.resp.MediaMusic;
import com.s1025.kuroko.module.passive.resp.MediaVideo;
import com.s1025.kuroko.module.passive.resp.RespArticle;
import com.s1025.kuroko.module.passive.resp.RespImg;
import com.s1025.kuroko.module.passive.resp.RespMusic;
import com.s1025.kuroko.module.passive.resp.RespNews;
import com.s1025.kuroko.module.passive.resp.RespText;
import com.s1025.kuroko.module.passive.resp.RespVideo;
import com.s1025.kuroko.module.passive.resp.RespVoice;
import com.s1025.mikoto.Mikoto;

public class PassiveService {
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
	
	public void sendRespText(ReqBase reqBase, String content, HttpServletResponse resp) throws IOException{
		RespText respText = getRespText(reqBase, content);
		String xml = Kuroko.parse.RespToXML(respText);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(xml);
		out.close();
	}
	
	public void sendRespImg(ReqBase reqBase, String mediaId, HttpServletResponse resp) throws IOException{
		RespImg respImg = getRespImg(reqBase, mediaId);
		String xml = Kuroko.parse.RespToXML(respImg);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(xml);
		out.close();
	}
	
	public void sendRespVoice(ReqBase reqBase, String mediaId, HttpServletResponse resp) throws IOException{
		RespVoice respVoice = getRespVoice(reqBase, mediaId);
		String xml = Kuroko.parse.RespToXML(respVoice);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(xml);
		out.close();
	}
	
	public void sendRespVideo(ReqBase reqBase, String mediaId, String title, String desc, HttpServletResponse resp) throws IOException{
		RespVideo respVideo = getRespVideo(reqBase, mediaId, title, desc);
		String xml = Kuroko.parse.RespToXML(respVideo);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(xml);
		out.close();
	}
	
	public void sendRespMusic(ReqBase reqBase, String title, String desc, String musicUrl, String hQMusicUrl, String thumb, HttpServletResponse resp) throws IOException{
		RespMusic respMusic = getRespMusic(reqBase, title, desc, musicUrl, hQMusicUrl, thumb);
		String xml = Kuroko.parse.RespToXML(respMusic);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(xml);
		out.close();
	}
	
	public void sendRespNews(ReqBase reqBase, int count, List<RespArticle> articles, HttpServletResponse resp) throws IOException{
		RespNews respNews = getRespNews(reqBase, count, articles);
		String xml = Kuroko.parse.RespToXML(respNews);
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		System.out.println(xml);
		out.write(xml);
		out.close();
	}
}
