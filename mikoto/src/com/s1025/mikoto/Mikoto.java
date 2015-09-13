package com.s1025.mikoto;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.plugin.router.Router;
import com.s1025.mikoto.api.AccessTokenApi;
import com.s1025.mikoto.api.AppApi;
import com.s1025.mikoto.api.GroupApi;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.api.MassApi;
import com.s1025.mikoto.api.MaterialApi;
import com.s1025.mikoto.api.MediaApi;
import com.s1025.mikoto.api.MenuApi;
import com.s1025.mikoto.api.PassiveApi;
import com.s1025.mikoto.api.UserApi;
import com.s1025.mikoto.builder.ReqBuilder;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.plugin.IRouter;
import com.s1025.mikoto.util.Builder;
import com.s1025.mikoto.util.Dev;
import com.s1025.mikoto.util.Parse;

public class Mikoto {
	
	public static App app = AppApi.getAppApi().getApp();
	public static String token;
	public static Parse parse = new Parse();
	
	public static boolean validate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		return Dev.validate(req, resp);
	}
	
	public static boolean router(HttpServletRequest req, HttpServletResponse resp){
		return true;
	}
	
	public void build(String appid, String appsecret, String token){
		new Builder().build(appid, appsecret);
		Mikoto.token = token;
	}
	
	public static class api{
		public static AccessTokenApi access = AccessTokenApi.getAccessTokenApi();
		public static GroupApi group = new GroupApi();
		public static KfApi kf = new KfApi();
		public static MassApi mass = new MassApi();
		public static MaterialApi material = new MaterialApi();
		public static MediaApi media = new MediaApi();
		public static MenuApi menu = new MenuApi();
		public static PassiveApi passive = new PassiveApi();
		public static UserApi user = new UserApi();
	}
	
	public static class plugin{
		public static IRouter router = new Router();
	}
	
	public static class builder{
		public static ReqBuilder req = new ReqBuilder();
	}
}
