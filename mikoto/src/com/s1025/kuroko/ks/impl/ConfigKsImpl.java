package com.s1025.kuroko.ks.impl;

import java.util.Properties;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.ks.ConfigKs;
import com.s1025.kuroko.util.Builder;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.App;

public class ConfigKsImpl implements ConfigKs{

	@Override
	public DBConfig getDB() {
		return Kuroko.config.dbConfig;
	}

	@Override
	public void setDB(DBConfig db, String path) {
		if(path==null){
			path = Kuroko.path.ppsPath;
		}
		
		Properties pps = Builder.getProperties(path);
		
		if(pps==null){
			pps = new Properties();
		}
		
		pps.setProperty("url", db.getUrl());
		pps.setProperty("user", db.getUser());
		pps.setProperty("passwd", db.getPasswd());
		
		Builder.saveProperties(pps, path);
		
	}
	
	@Override
	public void pushDB(String path) {
		if(path==null){
			path = Kuroko.path.ppsPath;
		}
		
		Properties pps = Builder.getProperties(path);
		
		if(pps==null){
			pps = new Properties();
		}
		
		DBConfig dbConfig = new DBConfig();
		dbConfig.setUrl(pps.getProperty("url"));
		dbConfig.setUser(pps.getProperty("user"));
		dbConfig.setPasswd(pps.getProperty("passwd"));
		
		Kuroko.config.dbConfig = dbConfig;
		
	}

	@Override
	public App getApp() {
		return Mikoto.app;
	}

	@Override
	public void setApp(App app, String path) {
		if(path==null){
			path = Kuroko.path.ppsPath;
		}
		
		Properties pps = Builder.getProperties(path);
		
		if(pps==null){
			pps = new Properties();
		}
		
		pps.setProperty("appid", app.getAppID());
		pps.setProperty("appsecret", app.getAppSecret());
		
		Builder.saveProperties(pps, path);
		
	}

	@Override
	public String getToken() {
		return Mikoto.token;
	}

	@Override
	public void setToken(String token, String path) {
		if(path==null){
			path = Kuroko.path.ppsPath;
		}
		
		Properties pps = Builder.getProperties(path);
		
		if(pps==null){
			pps = new Properties();
		}
		
		pps.setProperty("token", token);
		
		Builder.saveProperties(pps, path);
	}

	

	@Override
	public void pushApp(String path) {
		if(path==null){
			path = Kuroko.path.ppsPath;
		}
		
		Properties pps = Builder.getProperties(path);
		
		if(pps==null){
			pps = new Properties();
		}
		
		App app = new App();
		app.setAppID(pps.getProperty("appid"));
		app.setAppSecret(pps.getProperty("appsecret"));
		
		Mikoto.app = app;	
	}

	@Override
	public void pushToken(String path) {
		if(path==null){
			path = Kuroko.path.ppsPath;
		}
		
		Properties pps = Builder.getProperties(path);
		
		if(pps==null){
			pps = new Properties();
		}
		
		String token = pps.getProperty("token");
		
		Mikoto.token = token;
	}

}
