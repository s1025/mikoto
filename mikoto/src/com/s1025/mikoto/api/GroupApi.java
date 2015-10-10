package com.s1025.mikoto.api;

import java.util.List;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

/**
 * 用户分组.
 * @author fkxpjj
 *
 */
public class GroupApi {
	
	/**
	 * 创建分组的url。
	 */
	public String group_create_url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 查询所有分组的url。
	 */
	public String group_get_url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	
	/**
	 * 查询用户所在分组的url。
	 */
	public String group_getid_url = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	
	/**
	 * 修改分组名的url。
	 */
	public String group_update_url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	
	/**
	 * 移动用户分组的url。
	 */
	public String group_update_member_url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	
	/**
	 * 批量移动用户分组的url。
	 */
	public String group_update_members_url = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
	
	/**
	 * 删除分组的url。
	 */
	public String group_delete_url = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=ACCESS_TOKEN";
	
	/**
	 * 创建用户分组。
	 * @param name 分组名
	 * @return 返回json
	 */
	public String createGroup(String name){
		String url = group_create_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post="{\"group\":{\"name\":\""+name+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 获得所有分组。
	 * @return 返回json
	 */
	public String getGroup(){
		String url = group_get_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	/**
	 * 获得用户所在的分组。
	 * @param openid 用户的openid
	 * @return 返回json
	 */
	public String getGroup(String openid){
		String url = group_getid_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"openid\":\""+openid+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 修改分组名。
	 * @param id 分组id
	 * @param name 新的分组名
	 * @return 返回json
	 */
	public String updateGroup(int id, String name){
		String url = group_update_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"group\":{\"id\":"+id+",\"name\":\""+name+"\"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 移动用户分组
	 * @param openid 用户的openid
	 * @param groupid 新分组的id
	 * @return 返回json
	 */
	public String updateGroup(String openid, int groupid){
		String url = group_update_member_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"openid\":\""+openid+"\",\"to_groupid\":"+groupid+"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * 批量移动用户分组。
	 * @param openids 多个用户的openid
	 * @param groupid 新的分组id
	 * @return 返回json
	 */
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
	
	/**
	 * 删除分组。
	 * @param groupid 分组id
	 * @return 返回json
	 */
	public String deleteGroup(int groupid){
		String url = group_delete_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"group\":{\"id\":"+groupid+"}}";
		String response = HttpCon.httpRequest(url, "POST", post);
		System.out.println(response);
		return response;
	}
}
