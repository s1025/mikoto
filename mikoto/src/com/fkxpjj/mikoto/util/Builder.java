package com.fkxpjj.mikoto.util;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.model.App;

public class Builder {
	
	public void build(){
		App app = new App();
		app.setAppID("wx591b08daf676e085");
		app.setAppSecret("921057ddd269c0ec8481430db96cc1bc");
		setApp(app);
	}
	
	public void setApp(App app){
		Mikoto.appApi.setApp(app);
	}
}
