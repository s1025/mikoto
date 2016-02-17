package com.s1025.kuroko.ks;

import com.s1025.kuroko.dao.DBConfig;
import com.s1025.mikoto.model.App;

public interface ConfigKs {
	
	public DBConfig getDB();
	public void setDB(DBConfig db, String path);
	public void pushDB(String path);
	
	public App getApp();
	public void setApp(App app, String path);
	public void pushApp(String path);
	
	public String getToken();
	public void setToken(String token, String path);
	public void pushToken(String path);
}
