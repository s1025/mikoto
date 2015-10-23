package com.s1025.kuroko.module.menu;

import com.google.gson.Gson;
import com.s1025.kuroko.module.ErrResult;
import com.s1025.kuroko.module.Result;
import com.s1025.mikoto.Mikoto;

/**
 * �˵�����.
 * Ŀǰ���ṩ�����˵���ɾ���˵��Ĺ��ܣ���ѯ����û�С�
 * @author fkxpjj
 *
 */
public class MenuService {
	
	Gson gson = new Gson();
	
	/**
	 * �����˵�����Ҫһ���˵���������Ϊ����.
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
	 * ɾ���˵�.
	 * @return
	 */
	public Result<Menu> deleteMenu(){
		String re = Mikoto.api.menu.deleteMenu();
		ErrResult er = gson.fromJson(re, ErrResult.class);
		Result<Menu> r = new Result<Menu>(er);
		return r;
	}
	
	/**
	 * ���һ���˵�������.
	 * @return
	 */
	public MenuBuilder getMenuBuilder(){
		return new MenuBuilder();
	}
}
