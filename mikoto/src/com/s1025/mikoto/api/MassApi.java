package com.s1025.mikoto.api;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

public class MassApi {
	public String sendall_url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	public String preview_url = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	
	public String sendAll(String all, int groupId, String type, String content){
		String url = sendall_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		
		if("news".equals(type))
			type = "mpnews";
		
		String ctype="media_id";
		if("text".equals(type))
			ctype = "content";
		
		String post = "{\"filter\":{\"is_to_all\":"+all+",\"group_id\":\""+groupId+"\"},"
				+ "\""+type+"\":{\""+ctype+"\":\""+content+"\"},\"msgtype\":\""+type+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		System.out.println(post);
		return response;
	}
	
	public String preview(String openid, String type, String content){
		String url = sendall_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		
		if("news".equals(type))
			type = "mpnews";
		
		String ctype="media_id";
		if("text".equals(type))
			ctype = "content";
		
		String post = "{\"touser\":\""+openid+"\", \""+type+"\":{"              
            +"\""+ctype+"\":\""+content+"\"},\"msgtype\":\""+type+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		System.out.println(post);
		return response;
	}
}
