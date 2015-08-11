package com.fkxpjj.mikoto.api;

import java.util.List;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.RespArticle;
import com.fkxpjj.mikoto.util.HttpCon;
import com.google.gson.Gson;

public class KfApi {
	public String send_custom_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	public String add_kf_url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	public String get_kf_list_url = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	
	public String sendCustom(String openid, String type, String content) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\""+type+"\",\"text\":{\"content\":\""+content+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String sendCustomNews(String openid, List<RespArticle> list){
		Gson gson = new Gson();
		String json = gson.toJson(list);
		json = json.toLowerCase();
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\"news\",\"news\":{\"articles\":"+json+"}}";
		System.out.println(post);
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String addKf(String account, String name, String password){
		String url = add_kf_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String post = "{"+
                         "\"kf_account\" : \""+account+"\","+
                         "\"nickname\" : \""+name+"\","+
                         " \"password\" : \""+password+"\","+
                        "}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String getKfList(){
		String url = get_kf_list_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
