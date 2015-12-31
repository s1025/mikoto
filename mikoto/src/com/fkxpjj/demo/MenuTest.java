package com.fkxpjj.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.model.MenuBuilder;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.button.Button;
import com.s1025.kuroko.model.button.Menu;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class MenuTest {
	public static void main(String[] args){
		
		Init.init();
		create();
		delete();
	}
	
	public static void create(){
		Gson gson = new Gson();
		
		MenuBuilder mb = new MenuBuilder();
		mb.addClick("bt", "bb1", 1);
		mb.addSub("b2", 2);
		mb.addClick("b21", "d", 2);
		mb.addScancodePush("push", "1", 2);
		mb.addMediaId("image", "RFK3jX2re_SxlU4BVLgA-GMFo9PpFNAnN29U6HvyseM", 2);
		mb.addView("b3", "http://www.baidu.com", 3);
		
		
		//mb.addGroupRule("118");
		
		//String rs = gson.toJson(mb.getMenu());
		int rs = Kuroko.ks.menuKs.addMenu(mb.getMenu());
		//String rs = Mikoto.api.menu.getMenu();
		System.out.println(rs);
	}
	
	public static void delete(){
		
	}
}
