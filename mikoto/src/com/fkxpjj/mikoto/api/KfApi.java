package com.fkxpjj.mikoto.api;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;

public class KfApi {
	public static String send_custom_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	public static String add_kf_url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	public static String get_kf_list_url = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	
	public static final String TEXT = "text";
	
	public static String sendCustom(String openid, String type, String content) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\""+type+"\",\"text\":{\"content\":\""+content+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public static String addKf(String account, String name, String password){
		String url = add_kf_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String post = "{"+
                         "\"kf_account\" : \""+account+"\","+
                         "\"nickname\" : \""+name+"\","+
                         " \"password\" : \""+password+"\","+
                        "}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public static String getKfList(){
		String url = get_kf_list_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
