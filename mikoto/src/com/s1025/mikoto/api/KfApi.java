package com.s1025.mikoto.api;

import java.util.List;

import com.google.gson.Gson;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.active.ArticleKf;
import com.s1025.mikoto.util.HttpCon;

public class KfApi {
	/**
	 * ���Ϳͷ���Ϣ��url��
	 */
	public String send_custom_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	public String add_kf_url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	public String get_kf_list_url = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	
	/**
	 * ���������ı���Ϣ��
	 * @param openid �û���openid
	 * @param content ��������
	 * @return ����json
	 */
	public String sendCustomText(String openid, String content) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"text\",\"text\":{\"content\":\""+content+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * ��������ͼƬ��Ϣ��
	 * @param openid �û���openid
	 * @param mediaId �ز�id
	 * @return
	 */
	public String sendCustomImage(String openid, String mediaId) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"image\",\"image\":{\"media_id\":\""+mediaId+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * ��������������Ϣ��
	 * @param openid �û���openid
	 * @param mediaId �ز�id
	 * @return ����json
	 */
	public String sendCustomVoice(String openid, String mediaId) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\""+mediaId+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * ����������Ƶ��Ϣ��
	 * @param openid �û���openid
	 * @param mediaId �ز�id
	 * @param thumbMediaId ����ͼ�ز�id
	 * @param title ����
	 * @param desc ���
	 * @return ����json
	 */
	public String sendCustomVideo(String openid, String mediaId, String thumbMediaId, String title, String desc) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"video\",\"video\":"
				+ "{\"media_id\":\""+mediaId+"\",\"thumb_media_id\":\""+thumbMediaId+"\",\"title\":\""+title+"\",\"description\":\""+desc+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * ��������ͼ����Ϣ��
	 * @param openid �û���openid
	 * @param list ͼ��list
	 * @return ����json
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
	 * ��������������Ϣ��
	 * @param openid �û���openid
	 * @param title ����
	 * @param desc ���
	 * @param murl ��ͨ����url
	 * @param hqurl ��������url��wifi�����ȣ�
	 * @param thumb ����ͼ
	 * @return ����json
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
