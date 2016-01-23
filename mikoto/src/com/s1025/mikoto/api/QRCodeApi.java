package com.s1025.mikoto.api;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

public class QRCodeApi {
	public String create_qrcode_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	
	public String createQRCode(int seconds, int scene){
		String url = create_qrcode_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		System.out.println(url);
		String post = "{\"expire_seconds\": "+seconds+", \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+scene+"}}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String createLimitQRCode(int scene){
		String url = create_qrcode_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+scene+"}}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String createLimitQRCode(String scene){
		String url = create_qrcode_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+scene+"\"}}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
}
