package com.s1025.kuroko.module.menu;

import com.google.gson.Gson;
import com.s1025.kuroko.module.ErrResult;
import com.s1025.kuroko.module.Result;
import com.s1025.mikoto.Mikoto;

/**
 * 菜单管理.
 * 目前仅提供创建菜单和删除菜单的功能，查询功能没有。
 * @author fkxpjj
 *
 */
public class MenuService {
	
	Gson gson = new Gson();
	
	/**
	 * 创建菜单，需要一个菜单构建器作为参数.
	 * @param mb
	 * @return
	 */
	public Result<Menu> createMenu(MenuBuilder mb){
		String re = Mikoto.api.menu.createMenu(mb.toJson());
		ErrResult er = gson.fromJson(re, ErrResult.class);
		Result<Menu> r = new Result<Menu>(er);
		return r;
	}
	
	/**
	 * 删除菜单.
	 * @return
	 */
	public Result<Menu> deleteMenu(){
		String re = Mikoto.api.menu.deleteMenu();
		ErrResult er = gson.fromJson(re, ErrResult.class);
		Result<Menu> r = new Result<Menu>(er);
		return r;
	}
	
	/**
	 * 获得一个菜单构建器.
	 * @return
	 */
	public MenuBuilder getMenuBuilder(){
		return new MenuBuilder();
	}
}
