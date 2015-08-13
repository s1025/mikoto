package com.fkxpjj.mikoto.api;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.HttpCon;
import com.fkxpjj.mikoto.util.MenuBuilder;
import com.google.gson.Gson;
/**
 * 菜单工具类。
 * 
 * @author fkxpjj
 *
 */
public class MenuApi {

	/**
	 * 菜单创建接口
	 */
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
	
	/**
	 * 菜单查询接口
	 */
	public static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	/**
	 * 菜单删除接口
	 */
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	  

	/**
	 * 创建菜单。（有点问题）
	 * @param menu 菜单对象
	 * @return 返回json
	 */
	public static String createMenu(MenuBuilder menu) {  
	    Gson gson = new Gson();  
	    String url = menu_create_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());  
	    String jsonMenu = gson.toJson(menu);  
	    String response = HttpCon.httpRequest(url, "POST", jsonMenu);   
	    return response;  
	}  
	
	/**
	 * 菜单查询
	 * @return 返回json
	 */
	public static String getMenu(){
		String url = menu_get_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
	
	/**
	 * 删除菜单
	 * @return 返回json
	 */
	public static String deleteMenu() { 
		String url = menu_delete_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		String response = HttpCon.httpRequest(url, "GET", null);
		return response;
	}
}
