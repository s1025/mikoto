package com.s1025.mikoto.api;

import java.util.List;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

/**
 * 用户管理.
 * 
 * @author fkxpjj
 *
 */
public class UserApi {
	/**
	 * 设置用户备注名的url。
	 */
	public String update_remark_user_url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	
	/**
	 * 获得用户基本信息的url。
	 */
	public String info_user_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	/**
	 * 批量获得用户基本信息的url。
	 */
	public String info_users_url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	
	/**
	 * 获取用户列表的url。
	 */
	public String users_list_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	
	/**
	 * 设置用户备注名。
	 * @param openid 用户的openid
	 * @param remark 新的备注名
	 * @return 返回json
	 */
	public String updateUser(String openid, String remark){
		String url = update_remark_user_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"openid\":\""+openid+"\",\"remark\":\""+remark+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 获取用户基本信息。
	 * @param openid 用户的openid
	 * @return 返回json
	 */
	public String infoUser(String openid){
		String url = info_user_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		url = url.replace("OPENID", openid);
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	/**
	 * 批量获取用户基本信息。
	 * @param openids 用户openid的list
	 * @return 返回json
	 */
	public String infoUsers(List<String> openids){
		String url = info_users_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"user_list\": [";
		for(String openid:openids){
			post += "{\"openid\":\""+openid+"\",\"lang\":\"zh-CN\"},";
		}
		post = post.substring(0,post.length()-1);
		post += "]}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 获取用户列表。一次最多拉取10000个openid。
	 * @param openid 第一个拉取的openid（此id不包含在拉取列表中），不写默认从头拉取。
	 * @return 返回json
	 */
	public String usersList(String openid){
		if(openid==null) openid="";
		String url = users_list_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		url = url.replace("NEXT_OPENID", openid);
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
