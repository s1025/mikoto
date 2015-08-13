package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.util.Builder;

public class MenuTest {

	public static void main(String[] args) {
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String s = Mikoto.api.menu.getMenu();
		System.out.println(s);

	}

}
