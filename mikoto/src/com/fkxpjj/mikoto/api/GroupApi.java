package com.fkxpjj.mikoto.api;

import java.util.List;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;

public class GroupApi {
	
	public String group_create_url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	public String group_get_url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	public String group_getid_url = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	public String group_update_url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	public String group_update_member_url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	public String group_update_members_url = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
	public String group_delete_url = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=ACCESS_TOKEN";
	
	public String createGroup(String name){
		String url = group_create_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post="{\"group\":{\"name\":\""+name+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String getGroup(){
		String url = group_get_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	public String getGroup(String openid){
		String url = group_getid_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"openid\":\""+openid+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String updateGroup(int id, String name){
		String url = group_update_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"group\":{\"id\":"+id+",\"name\":\""+name+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String updateGroup(String openid, int groupid){
		String url = group_update_member_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"openid\":\""+openid+"\",\"to_groupid\":"+groupid+"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String updateGroup(List<String> openids, int groupid){
		String url = group_update_members_url.replace("ACCESS_TOLEN", Mikoto.api.access.getAccessToken());
		StringBuilder openidList = new StringBuilder();
		for(int i=0 ; i<openids.size() ; i++){
			openidList.append("\"");
			openidList.append(openids.get(i));
			openidList.append("\"");
			if(i<openids.size()-1){
				openidList.append(",");
			}
		}
		String post = "{\"openid_list\":["+openidList.toString()+"],\"to_groupid\":"+groupid+"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	public String deleteGroup(int groupid){
		String url = group_delete_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"group\":{\"id\":"+groupid+"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
}
