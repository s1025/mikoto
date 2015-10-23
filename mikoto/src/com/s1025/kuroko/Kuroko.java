package com.s1025.kuroko;

import com.s1025.kuroko.builder.ReqBuilder;
import com.s1025.kuroko.module.menu.MenuService;
import com.s1025.kuroko.module.user.UserService;

public class Kuroko {
	
	public static class builder{
		public static ReqBuilder req = new ReqBuilder();
		
		public static class service{
			public static UserService user = new UserService();
			public static MenuService menu = new MenuService();
		}
	}
}
