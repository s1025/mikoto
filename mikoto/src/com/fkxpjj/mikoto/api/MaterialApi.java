package com.fkxpjj.mikoto.api;

import java.util.HashMap;
import java.util.Map;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;

public class MaterialApi {
	/**
	 * 获得永久素材总数的url。
	 */
	public String material_count_url = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	
	/**
	 * 获得永久素材列表的url。
	 */
	public String material_list_url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";

	/**
	 * 上传永久素材的url。
	 */
	public String material_add = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
	
	public String material_delete = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
	
	public String delMaterial(String mediaId){
		String url = material_delete.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"media_id\":\""+mediaId+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	
	/**
	 * 上传永久素材
	 * @param type 类型：image、voice、video、thumb
	 * @param path 文件路径
	 * @return 返回json
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
		Map<String, String> map = new HashMap<String, String>();
		map.put("rrr", path);
		Map<String, String> resp = new HashMap<String, String>();
		resp.put("title", title);
		resp.put("introduction", intro);
		String response = HttpCon.upload(url, resp, map);
		return response;
	}
	
	/**
	 * 获得永久素材总数
	 * @return 返回json
	 */
	public String materialCount(){
		String url = material_count_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	/**
	 * 获取永久素材列表。
	 * @param type 类型：image、video、voice、news
	 * @param offset 从偏移位置开始返回，0为第一个
	 * @param count 返回数量，大于等于1小于等于20
	 * @return 返回json
	 */
	public String materialList(String type, int offset, int count){
		String url = material_list_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"type\":\""+type+"\",\"offset\":"+offset+",\"count\":"+count+"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
}
