package com.fkxpjj.mikoto;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fkxpjj.mikoto.util.Builder;

public class MikotoListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String appid = servletContext.getInitParameter("appid");
		String appsecret = servletContext.getInitParameter("appsecret");
		System.out.println(appid+" , "+ appsecret);
		new Builder().build(appid, appsecret);
		
	}

}
