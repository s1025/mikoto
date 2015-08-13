package com.fkxpjj.mikoto.api;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;
import com.fkxpjj.mikoto.util.MenuBuilder;
import com.google.gson.Gson;
/**
 * �˵������ࡣ
 * 
 * @author fkxpjj
 *
 */
public class MenuApi {

	/**
	 * �˵������ӿ�
	 */
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
	
	/**
	 * �˵���ѯ�ӿ�
	 */
	public static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	/**
	 * �˵�ɾ���ӿ�
	 */
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	  

	/**
	 * �����˵������е����⣩
	 * @param menu �˵�����
	 * @return ����json
	 */
	public static String createMenu(MenuBuilder menu) {  
	    Gson gson = new Gson();  
	    String url = menu_create_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());  
	    String jsonMenu = gson.toJson(menu);  
	    String response = HttpCon.httpRequest(url, "POST", jsonMenu);   
	    return response;  
	}  
	
	/**
	 * �˵���ѯ
	 * @return ����json
	 */
	public static String getMenu(){
		String url = menu_get_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	/**
	 * ɾ���˵�
	 * @return ����json
	 */
	public static String deleteMenu() { 
		String url = menu_delete_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
