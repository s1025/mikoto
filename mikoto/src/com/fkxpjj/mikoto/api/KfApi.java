package com.fkxpjj.mikoto.api;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;

public class KfApi {
	public static String send_custom_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	public static final String TEXT = "text";
	
	public static String sendCustom(String openid, String type, String content) {
		String url = send_custom_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String post = "{\"touser\":\""+openid+"\",\"msgtype\":\""+type+"\",\"text\":{\"content\":\""+content+"\"}}";
		System.out.println(post);
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
}
