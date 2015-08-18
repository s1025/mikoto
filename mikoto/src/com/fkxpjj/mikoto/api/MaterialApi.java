package com.fkxpjj.mikoto.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.active.ArticleMaterial;
import com.fkxpjj.mikoto.util.HttpCon;
import com.google.gson.Gson;

public class MaterialApi {
	/**
	 * ��������ز�������url��
	 */
	public String material_count_url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	
	/**
	 * ��������ز��б��url��
	 */
	public String material_list_url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";

	/**
	 * �ϴ������زĵ�url��
	 */
	public String material_add = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
	
	/**
	 * ɾ�������زĵ�url��
	 */
	public String material_delete = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
	
	public String add_news_img = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	
	public String add_news = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	
	/**
	 * ɾ�������زġ�
	 * @param mediaId �ز�id
	 * @return ����json
	 */
	public String delMaterial(String mediaId){
		String url = material_delete.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"media_id\":\""+mediaId+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	
	/**
	 * �ϴ������ز�
	 * @param type ���ͣ�image��voice��thumb
	 * @param path �ļ�·��
	 * @return ����json
	 */
	public String addMaterial(String type, String path){
		String url = material_add.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		url = url.replace("TYPE", type);
		Map<String, String> map = new HashMap<String, String>();
		map.put("rrr", path);
		String response = HttpCon.upload(url, null, map);
		return response;
	}
	
	
	public String addMaterialVideo(String path, String title, String intro){
		String url = material_add.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		url = url.replace("TYPE", "video");
		Map<String, String> file = new HashMap<String, String>();
		Map<String, String> resp = new HashMap<String, String>();
		file.put("media", path);
		String json = "{\"title\":"+title+",\"introduction\":"+intro+"}";
		resp.put("json", json);
		String response = HttpCon.upload(url, resp, file);
		return response;
	}
	
	/**
	 * ��������ز�����
	 * @return ����json
	 */
	public String materialCount(){
		String url = material_count_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	/**
	 * ��ȡ�����ز��б�
	 * @param type ���ͣ�image��video��voice��news
	 * @param offset ��ƫ��λ�ÿ�ʼ���أ�0Ϊ��һ��
	 * @param count �������������ڵ���1С�ڵ���20
	 * @return ����json
	 */
	public String materialList(String type, int offset, int count){
		String url = material_list_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"type\":\""+type+"\",\"offset\":"+offset+",\"count\":"+count+"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String addNewsImg(String path){
		String url = add_news_img.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		Map<String, String> map = new HashMap<String, String>();
		map.put("rrr", path);
		String response = HttpCon.upload(url, null, map);
		return response;
	}
	
	public String addNews(List<ArticleMaterial> articles){
		String url = add_news.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		Gson gson = new Gson();
		String as = gson.toJson(articles);
		String post = "{\"articles\": "+as+"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
}
