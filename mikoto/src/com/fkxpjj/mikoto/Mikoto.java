package com.fkxpjj.mikoto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;














import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fkxpjj.mikoto.api.AccessTokenApi;
import com.fkxpjj.mikoto.api.AppApi;
import com.fkxpjj.mikoto.api.GroupApi;
import com.fkxpjj.mikoto.api.KfApi;
import com.fkxpjj.mikoto.api.MenuApi;
import com.fkxpjj.mikoto.api.PassiveApi;
import com.fkxpjj.mikoto.api.UserApi;
import com.fkxpjj.mikoto.model.App;
import com.fkxpjj.mikoto.model.button.Button;
import com.fkxpjj.mikoto.util.Dev;
import com.fkxpjj.mikoto.util.Parse;

public class Mikoto {
	
	public static App app = AppApi.getAppApi().getApp();
	public static String token;
	public static Parse parse = new Parse();
	
	public static boolean validate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		return Dev.validate(req, resp);
	}
	
	public static class api{
		public static AccessTokenApi access = AccessTokenApi.getAccessTokenApi();
		public static GroupApi group = new GroupApi();
		public static KfApi kf = new KfApi();
		public static MenuApi menu = new MenuApi();
		public static PassiveApi passive = new PassiveApi();
		public static UserApi user = new UserApi();
	}
}
