package com.fkxpjj.mikoto.api;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;

public class MassApi {
	public String sendall = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	
	public String sendallMedia(String all, String groupId, String mediaId, String type){
		String url = sendall.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"filter\":{\"is_to_all\":"+all+",\"group_id\":\""+groupId+"\"},"
				+ "\""+type+"\":{\"media_id\":\""+mediaId+"\"},\"msgtype\":\""+type+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		System.out.println(post);
		return response;
	}
}
