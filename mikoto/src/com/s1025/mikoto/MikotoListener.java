package com.s1025.mikoto;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.s1025.mikoto.util.Dev;



public class MikotoListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String appid = servletContext.getInitParameter("appid");
		String appsecret = servletContext.getInitParameter("appsecret");
		String token = servletContext.getInitParameter("token");
		Mikoto.build(appid, appsecret, token);
	}

}
