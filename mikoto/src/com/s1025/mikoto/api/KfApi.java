package com.s1025.mikoto.api;

import java.util.List;

import com.google.gson.Gson;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.active.ArticleKf;
import com.s1025.mikoto.util.HttpCon;

public class KfApi {
	/**
	 * 发送客服消息的url。
	 */
	public String send_custom_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	public String add_kf_url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	public String get_kf_list_url = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	
	/**
	 * 主动发送文本消息。
	 * @param openid 用户的openid
	 * @param content 文字内容
	 * @return 返回json
	 */
	public String sendCustomText(String openid, String content) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"text\",\"text\":{\"content\":\""+content+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 主动发送图片消息。
	 * @param openid 用户的openid
	 * @param mediaId 素材id
	 * @return
	 */
	public String sendCustomImage(String openid, String mediaId) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"image\",\"image\":{\"media_id\":\""+mediaId+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 主动发送语音消息。
	 * @param openid 用户的openid
	 * @param mediaId 素材id
	 * @return 返回json
	 */
	public String sendCustomVoice(String openid, String mediaId) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\""+mediaId+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 主动发送视频消息。
	 * @param openid 用户的openid
	 * @param mediaId 素材id
	 * @param thumbMediaId 缩略图素材id
	 * @param title 标题
	 * @param desc 简介
	 * @return 返回json
	 */
	public String sendCustomVideo(String openid, String mediaId, String thumbMediaId, String title, String desc) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"video\",\"video\":"
				+ "{\"media_id\":\""+mediaId+"\",\"thumb_media_id\":\""+thumbMediaId+"\",\"title\":\""+title+"\",\"description\":\""+desc+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 主动发送图文消息。
	 * @param openid 用户的openid
	 * @param list 图文list
	 * @return 返回json
	 */
	public String sendCustomNews(String openid, List<ArticleKf> list){
		Gson gson = new Gson();
		String json = gson.toJson(list);
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"news\",\"news\":{\"articles\":"+json+"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 主动发送音乐信息。
	 * @param openid 用户的openid
	 * @param title 标题
	 * @param desc 简介
	 * @param murl 普通音质url
	 * @param hqurl 高清音质url（wifi下优先）
	 * @param thumb 缩略图
	 * @return 返回json
	 */
	public String sendCustomMusic(String openid, String title, String desc, String murl, String hqurl, String thumb){
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"music\",\"music\":"
				+ "{\"title\":\""+title+"\",\"description\":\""+desc+"\","
				+ "\"musicurl\":\""+murl+"\",\"hqmusicurl\":\""+hqurl+"\",\"thumb_media_id\":\""+thumb+"\" }}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String addKf(String account, String name, String password){
		String url = add_kf_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{"+
                         "\"kf_account\" : \""+account+"\","+
                         "\"nickname\" : \""+name+"\","+
                         " \"password\" : \""+password+"\","+
                        "}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String getKfList(){
		String url = get_kf_list_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
