package com.fkxpjj.mikoto.util;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.App;

public class Builder {
	
	public void build(String appid, String appsecret){
		App app = new App();
		app.setAppID(appid);
		app.setAppSecret(appsecret);
		setApp(app);
		System.out.println(app);
	}
	
	public void setApp(App app){
		Mikoto.appApi.setApp(app);
	}
}
