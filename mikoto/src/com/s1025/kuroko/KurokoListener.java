package com.s1025.kuroko;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.s1025.kuroko.dao.DB;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.util.Builder;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;


/**
 * 配置初始化.
 * 将配置文件里面的数据分别放入相应的地方。
 * @author fkxpjj
 *
 */
public class KurokoListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String path = servletContext.getRealPath("/WEB-INF/kuroko.properties");
		
		Kuroko.path.ppsPath = path;
		Kuroko.path.actionPath = servletContext.getRealPath("/WEB-INF/actions.xml");
		
		Kuroko.ks.configKs.pushApp(null);
		Kuroko.ks.configKs.pushDB(null);
		Kuroko.ks.configKs.pushToken(null);
		
		DB.init();
		
		
	}

}
