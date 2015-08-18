package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.builder.MenuBuilder;
import com.fkxpjj.mikoto.model.button.ButtonClick;
import com.fkxpjj.mikoto.model.button.ButtonSub;
import com.fkxpjj.mikoto.model.button.ButtonType;
import com.fkxpjj.mikoto.model.button.ButtonView;
import com.fkxpjj.mikoto.util.Builder;

public class MenuTest {

	public static void main(String[] args) {
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		MenuBuilder bu = new MenuBuilder();
		
		bu.addClick("c1", "1", 0);
		bu.addView("c2", "http://www.baidu.com", 1);
		bu.addSub("c3", 2);
		bu.addClick("c31", "5", 2);
		bu.addMedia("c32", "UFAuIan48n9bY_wbqR0kfgzwDTtt-xcpsWuss0k4b5w", 2);
		bu.addScancodeWaitmsg("cc5", "55", 2);
		String s = bu.toJson();
		System.out.println(s);
		
		String r = Mikoto.api.menu.createMenu(s);
		System.out.println(r);

	}

}
