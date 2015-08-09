package com.fkxpjj.mikoto;

import java.util.ArrayList;
import java.util.List;




import com.fkxpjj.mikoto.api.AccessTokenApi;
import com.fkxpjj.mikoto.api.AppApi;
import com.fkxpjj.mikoto.api.Passive;
import com.fkxpjj.mikoto.model.Button;
import com.fkxpjj.mikoto.util.Parse;

public class Mikoto {
	
	public static AccessTokenApi accessTokenApi = AccessTokenApi.getAccessTokenApi();
	public static AppApi appApi = AppApi.getAppApi();
	public static String token;
	public static Parse parse = new Parse();
	
	public static class api{
		public static Passive passive = new Passive();
	}
	
	public static String connect(String signature,String timestmp,String nonce,String echostr){
		return echostr;
	}
	
	public static void builder(){
		System.out.println("build");
	}
	
	public static void getMenu(Button button1){
		getMenu(button1,null);
	}
	
	public static void getMenu(Button button1,Button button2){
		getMenu(button1,button2,null);
	}
	
	public static void getMenu(Button button1,Button button2,Button button3){
		List<Button> menu = new ArrayList<Button>();
		if(!(button1 == null)){
			menu.add(button1);
		}
		if(!(button2 == null)){
			menu.add(button2);
		}
		if(!(button3 == null)){
			menu.add(button3);
		}
	}
}
