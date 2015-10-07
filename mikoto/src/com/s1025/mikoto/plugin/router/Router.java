package com.s1025.mikoto.plugin.router;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.mikoto.plugin.IRouter;

public class Router implements IRouter{
	Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean service(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

}
