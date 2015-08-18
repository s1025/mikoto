package com.s1025.mikoto.api;

import com.s1025.mikoto.model.App;

public class AppApi {
	private App app = new App();
	private static AppApi appApi = new AppApi();
	
	private AppApi(){}
	
	public static AppApi getAppApi(){
		return appApi;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
}