package com.s1025.mikoto;

import java.io.IOException;

import com.s1025.mikoto.api.AccessTokenApi;
import com.s1025.mikoto.api.DatacubeApi;
import com.s1025.mikoto.api.GroupApi;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.api.MassApi;
import com.s1025.mikoto.api.MaterialApi;
import com.s1025.mikoto.api.MediaApi;
import com.s1025.mikoto.api.MenuApi;
import com.s1025.mikoto.api.UserApi;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.util.Dev;

public class Mikoto {
	
	/**
	 * 
	 */
	public static App app;
	
	/**
	 * 服务端接入验证的字段，初始化时注入。
	 */
	public static String token;
	
	public static class api{
		public static AccessTokenApi access = AccessTokenApi.getAccessTokenApi();
		public static GroupApi group = new GroupApi();
		public static KfApi kf = new KfApi();
		public static MassApi mass = new MassApi();
		public static MaterialApi material = new MaterialApi();
		public static MediaApi media = new MediaApi();
		public static MenuApi menu = new MenuApi();
		public static UserApi user = new UserApi();
		public static DatacubeApi datacube = new DatacubeApi();
	}
	
	/**
	 * 初始化.
	 * 每个微信公众号都含有appid和appsecret，所有的调用都需要这两个参数。
	 * 此函数只能用于本地测试主动调用。
	 * @param appid
	 * @param appsecret
	 */
	public static void build(String appid, String appsecret){
		App app = new App();
		app.setAppID(appid);
		app.setAppSecret(appsecret);
		Mikoto.app = app;
	}
	
	/**
	 * 初始化.
	 * 多含有一个token参数，进行服务器验证。
	 * @param appid
	 * @param appsecret
	 * @param token
	 */
	public static void build(String appid, String appsecret, String token){
		build(appid, appsecret);
		Mikoto.token = token;
	}
	
	/**
	 * 服务器接入验证.
	 * 获取四个相关参数，并反回是否验证成功
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return 返回是否成功，布尔型
	 * @throws IOException
	 */
	public static boolean validate(String signature, String timestamp, String nonce, String echostr) throws IOException{
		return Dev.validate(signature, timestamp, nonce, echostr, token);
	}
}
