package com.fkxpjj.demo;

import java.util.Properties;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.util.Builder;
import com.s1025.mikoto.model.App;

public class PTest {

	public static void main(String[] args) {
		String path = "D:\\1.p";
		//p.setProperty("a", "v");
		App app = new App();
		app.setAppID("idid");
		app.setAppSecret("asec");
		Kuroko.ks.configKs.setApp(app, path);

	}

}
