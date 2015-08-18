package com.fkxpjj.mikoto.demo;



import java.util.ArrayList;
import java.util.List;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.api.UserApi;
import com.fkxpjj.mikoto.util.Builder;

public class Test {
	public static void main(String[] args){
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");/*
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
		
		ClickButton button3 = new ClickButton();
		button3.setType(Button.CLICK);
		button3.setName("aa3");
		button3.setKey("a31");

		
		Menu menu = new Menu();
		menu.add(button3);
		menu.add(subbutton);
		
		String r = MenuApi.createMenu(menu);
		System.out.println(r);
		*/
		//List<Menu> list = new ArrayList<Menu>();
		//list.add(2, new Menu());
		//System.out.println(list.size());
		/*
		new Builder().build();
		
		AccessToken accessToken = Mikoto.accessTokenApi.getAccessToken();
		System.out.println(accessToken.getAccess_token());
		System.out.println(accessToken.getAccess_token().length());
		System.out.println(accessToken.getExpires_in());
		System.out.println(accessToken.getExpires_in().length());
		*/
		
		//String s = MenuApi.deleteMenu();
		//System.out.println(s);
		
		//String s = Mikoto.api.user.infoUser("oVW-oszd62QE_kT66ilsRuuOJspA");
		//System.out.println(s);
		
		List<String> openids = new ArrayList<String>();
		openids.add("oVW-os9UkORwWvVlp09R4hAaPCF4");
		openids.add("oVW-oszd62QE_kT66ilsRuuOJspA");
		
		String s = Mikoto.api.group.getGroup();
		
		System.out.println(s);
	}
}
