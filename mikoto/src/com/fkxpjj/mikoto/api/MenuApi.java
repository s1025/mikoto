package com.fkxpjj.mikoto.api;

import java.util.List;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.button.Button;
import com.fkxpjj.mikoto.model.button.Menu;
import com.fkxpjj.mikoto.util.HttpCon;
import com.google.gson.Gson;
/**
 * �˵������ࡣ
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

	// �˵�������POST�� ��100����/�죩  
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	  
	/** 
	 * �����˵� 
	 *  
	 * @param menu �˵�ʵ�� 
	 * @param accessToken ��Ч��access_token 
	 * @return 0��ʾ�ɹ�������ֵ��ʾʧ�� 
	 */
	public static String createMenu(MenuApi menu) {  
	    Gson gson = new Gson();
	    // ƴװ�����˵���url  
	    String url = menu_create_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());  
	    // ���˵�����ת����json�ַ���  
	    String jsonMenu = gson.toJson(menu);  
	    
	    // ���ýӿڴ����˵�  
	    String response = HttpCon.httpRequest(url, "POST", jsonMenu);   
	  
	    return response;  
	}  
	
	public static String deleteMenu() { 
		
		String url = menu_delete_url.replace("ACCESS_TOKEN", Mikoto.api.access.getAccessToken());
		
		String response = HttpCon.httpRequest(url, "GET", null);
		
		return response;
	}
}
