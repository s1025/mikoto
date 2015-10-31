package com.s1025.kuroko.module.router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IRouter {
	public boolean service(HttpServletRequest req, HttpServletResponse resp);
	public void init();
	public void destory();
}
