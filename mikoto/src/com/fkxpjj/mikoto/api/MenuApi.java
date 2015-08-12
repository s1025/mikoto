package com.fkxpjj.mikoto.api;

import java.util.List;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.button.Button;
import com.fkxpjj.mikoto.model.button.Menu;
import com.fkxpjj.mikoto.util.HttpCon;
import com.google.gson.Gson;
/**
 * 菜单工具类。
 * 
 * @author fkxpjj
 *
 */
public class MenuApi {
	
	private List<Button> menu ;
	
	public List<Button> getMenu() {
		return menu;
	}

	public void setMenu(List<Button> menu) {
		this.menu = menu;
	}

	// 菜单创建（POST） 限100（次/天）  
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	  
	/** 
	 * 创建菜单 
	 *  
	 * @param menu 菜单实例 
	 * @param accessToken 有效的access_token 
	 * @return 0表示成功，其他值表示失败 
	 */
	public static String createMenu(MenuApi menu) {  
	    Gson gson = new Gson();
	    // 拼装创建菜单的url  
	    String url = menu_create_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());  
	    // 将菜单对象转换成json字符串  
	    String jsonMenu = gson.toJson(menu);  
	    
	    // 调用接口创建菜单  
	    String response = HttpCon.httpRequest(url, "POST", jsonMenu);   
	  
	    return response;  
	}  
	
	public static String deleteMenu() { 
		
		String url = menu_delete_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		
		String response = HttpCon.httpRequest(url, "GET", null);
		
		return response;
	}
}
