package com.s1025.mikoto.plugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IRouter {
	public void init();
	public boolean service(HttpServletRequest req, HttpServletResponse resp);
	public void destory();
}
