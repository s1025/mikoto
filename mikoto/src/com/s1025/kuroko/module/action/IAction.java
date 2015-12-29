package com.s1025.kuroko.module.action;

import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.model.req.ReqText;


public interface IAction {
	public void init();
	public boolean service(ReqText reqText, HttpServletResponse resp);
	public void destory();
}
