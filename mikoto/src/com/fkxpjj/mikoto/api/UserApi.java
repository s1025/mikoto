package com.fkxpjj.mikoto.api;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;

public class UserApi {
	public String update_remark_user_url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	public String info_user_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	public String updateUser(String openid, String remark){
		String url = update_remark_user_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		String post = "{\"openid\":\""+openid+"\",\"remark\":\""+remark+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String infoUser(String openid, String lang){
		String url = info_user_url.replace("ACCESS_TOKEN", Mikoto.accessTokenApi.getAccessToken().getAccess_token());
		url = url.replace("OPENID", openid);
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
