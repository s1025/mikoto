package com.s1025.kuroko;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.util.Builder;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;



public class KurokoListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String path = servletContext.getRealPath("/WEB-INF/kuroko.properties");
		Properties pps = Builder.getProperties(path);
		
		String appid = pps.getProperty("appid");
		String appsecret = pps.getProperty("appsecret");
		String token = pps.getProperty("token");
		
		String url = pps.getProperty("url");
		String user = pps.getProperty("user");
		String passwd = pps.getProperty("passwd");
		
		Mikoto.app = new App(appid,appsecret);
		Mikoto.token = token;
		
		DBConfig dbConfig = DBConfig.get();
		dbConfig.setUrl(url);
		dbConfig.setUser(user);
		dbConfig.setPasswd(passwd);
	}

}
