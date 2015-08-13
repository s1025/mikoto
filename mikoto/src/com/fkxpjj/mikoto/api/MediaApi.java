package com.fkxpjj.mikoto.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;

public class MediaApi {
	/**
	 * �ϴ���ʱ�زĵ�url��
	 */
	public String media_upload_url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	
	/**
	 * �ϴ���ʱ�زġ�
	 * @param type ���ͣ�image��voice��video��thumb
	 * @param path  �ļ�·��
	 * @return  ����json
	 * @throws IOException
	 */
	public String uploadMedia(String type, String path) throws IOException{
		String url = media_upload_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		url = url.replace("TYPE", type);
		Map<String, String> map = new HashMap<String, String>();
		map.put("rrr", path);
		String response = HttpCon.upload(url, null, map);
		return response;
	}
}
