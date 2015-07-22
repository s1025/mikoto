package com.fkxpjj.mikoto.demo;


import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.api.AccessTokenApi;
import com.fkxpjj.mikoto.api.MenuApi;
import com.fkxpjj.mikoto.model.AccessToken;
import com.fkxpjj.mikoto.model.App;
import com.fkxpjj.mikoto.model.BaseButton;
import com.fkxpjj.mikoto.model.Button;
import com.fkxpjj.mikoto.model.ClickButton;
import com.fkxpjj.mikoto.model.Menu;
import com.fkxpjj.mikoto.model.PopupButton;
import com.fkxpjj.mikoto.model.ViewButton;
import com.fkxpjj.mikoto.util.Builder;
import com.google.gson.Gson;

public class Test {
	public static void main(String[] args){
		new Builder().build();
		Gson gson = new Gson();
		
		ClickButton button1 = new ClickButton();
		button1.setType(Button.CLICK);
		button1.setName("aa");
		button1.setKey("a1");
		
		ViewButton button2 = new ViewButton();
		button2.setType(Button.VIEW);
		button2.setName("aa2");
		button2.setUrl("http://www.baidu.com");
		
		PopupButton subbutton = new PopupButton();
		subbutton.setName("sub");
		subbutton.add(button1);
		subbutton.add(button2);
		//subbutton.setSub_button(new Button[]{button1,button2});
		
		ClickButton button3 = new ClickButton();
		button3.setType(Button.CLICK);
		button3.setName("aa3");
		button3.setKey("a31");

		
		Menu menu = new Menu();
		menu.add(button3);
		menu.add(subbutton);
		
		
		//menu.setButton(new Button[]{button3,subbutton});
		
		String json = gson.toJson(menu);
		System.out.println(json);
		
		String r = MenuApi.createMenu(menu);
		System.out.println(r);
		
		/*
		new Builder().build();
		
		AccessToken accessToken = Mikoto.accessTokenApi.getAccessToken();
		System.out.println(accessToken.getAccess_token());
		System.out.println(accessToken.getAccess_token().length());
		System.out.println(accessToken.getExpires_in());
		System.out.println(accessToken.getExpires_in().length());
		*/
	}
}
