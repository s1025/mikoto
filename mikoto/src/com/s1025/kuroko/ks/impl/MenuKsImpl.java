package com.s1025.kuroko.ks.impl;

import com.google.gson.Gson;
import com.s1025.kuroko.ks.MenuKs;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.button.Menu;
import com.s1025.mikoto.Mikoto;

public class MenuKsImpl implements MenuKs{
	Gson gson = new Gson();
	
	@Override
	public Result<Menu> addMenu(Menu menu, boolean r) {
		String re = "";
		if(menu.getMatchrule()==null)
			re = Mikoto.api.menu.createMenu(gson.toJson(menu));
		else
			re = Mikoto.api.menu.createCMenu(gson.toJson(menu));
		if(KuUtil.isResultSuccess(re)){
			int ri = 0;
			Result<Menu> rs = new Result<Menu>();
			rs.setErrcode(0);
			rs.setErrmsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Menu> rs = new Result<Menu>(er);
			return rs;
		}
	}

	@Override
	public int addMenu(Menu menu) {
		Result<Menu> rs = addMenu(menu, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}
	
	
	@Override
	public Result<Menu> getMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Menu> delMenu(boolean r) {
		String re = Mikoto.api.menu.deleteMenu();
		if(KuUtil.isResultSuccess(re)){
			int ri = 0;
			Result<Menu> rs = new Result<Menu>();
			rs.setErrcode(0);
			rs.setErrmsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<Menu> rs = new Result<Menu>(er);
			return rs;
		}
	}
	
	@Override
	public int delMenu() {
		Result<Menu> rs = delMenu(true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}


}
