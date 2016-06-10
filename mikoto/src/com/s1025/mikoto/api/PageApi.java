package com.s1025.mikoto.api;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

public class PageApi {
	public String get_access_token = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	
	public String authorize(String code){
		
		String url = get_access_token.replace("APPID", Mikoto.app.getAppID());    
		url = url.replace("SECRET", Mikoto.app.getAppSecret());
		url = url.replace("CODE", code);
		
		String response = HttpCon.httpRequest(url, "GET", null);
		
		return response;
	}
}
