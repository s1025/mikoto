package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.button.Menu;

public interface MenuKs {
	public Result<Menu> addMenu(Menu menu, boolean r);
	public int addMenu(Menu menu);
	
	public Result<Menu> getMenu();
	
	public Result<Menu> delMenu(boolean r);
	public int delMenu();
}
