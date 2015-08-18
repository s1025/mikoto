package com.s1025.mikoto.api;

import java.util.List;

import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.HttpCon;

/**
 * �û�����.
 * 
 * @author fkxpjj
 *
 */
public class UserApi {
	/**
	 * �����û���ע����url��
	 */
	public String update_remark_user_url = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	
	/**
	 * ����û�������Ϣ��url��
	 */
	public String info_user_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	/**
	 * ��������û�������Ϣ��url��
	 */
	public String info_users_url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	
	/**
	 * ��ȡ�û��б��url��
	 */
	public String users_list_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	
	/**
	 * �����û���ע����
	 * @param openid �û���openid
	 * @param remark �µı�ע��
	 * @return ����json
	 */
	public String updateUser(String openid, String remark){
		String url = update_remark_user_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String post = "{\"openid\":\""+openid+"\",\"remark\":\""+remark+"\"}";
		String response = HttpCon.httpRequest(url, "POST", post);
		return response;
	}
	
	/**
	 * ��ȡ�û�������Ϣ��
	 * @param openid �û���openid
	 * @return ����json
	 */
	public String infoUser(String openid){
		String url = info_user_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		url = url.replace("OPENID", openid);
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	/**
	 * ������ȡ�û�������Ϣ��
	 * @param openids �û�openid��list
	 * @return ����json
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
	 * ��ȡ�û��б�һ�������ȡ10000��openid��
	 * @param openid ��һ����ȡ��openid����id����������ȡ�б��У�����дĬ�ϴ�ͷ��ȡ��
	 * @return ����json
	 */
	public String usersList(String openid){
		if(openid==null) openid="";
		String url = users_list_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		url = url.replace("NEXT_OPENID", openid);
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
