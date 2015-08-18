package com.s1025.mikoto.util;

import com.s1025.mikoto.api.AppApi;
import com.s1025.mikoto.model.App;

public class Builder {
	
	public void build(String appid, String appsecret){
		App app = new App();
		app.setAppID(appid);
		app.setAppSecret(appsecret);
		setApp(app);
	}
	
	public void setApp(App app){
		AppApi.getAppApi().setApp(app);;
	}
}
