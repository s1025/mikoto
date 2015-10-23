package com.fkxpjj.demo;

import com.s1025.kuroko.module.Result;
import com.s1025.kuroko.module.menu.Menu;
import com.s1025.kuroko.module.menu.MenuBuilder;
import com.s1025.kuroko.module.menu.MenuService;
import com.s1025.mikoto.Mikoto;

public class MenuTest {
	public static void main(String[] args){
		Mikoto.build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		MenuBuilder mb = new MenuBuilder();
		
		MenuService ms = new MenuService();
		
		mb.addClick("s1", "sss", 1);
		mb.addSub("s2", 1);
		mb.addClick("s3", "s33", 1);		
		
		//System.out.println(mb.toJson());
		Result<Menu> re = ms.deleteMenu();
		System.out.println(re);
	}
}
