package com.s1025.mikoto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.plugin.router.Router;
import com.s1025.kuroko.util.Parse;
import com.s1025.mikoto.api.AccessTokenApi;
import com.s1025.mikoto.api.DatacubeApi;
import com.s1025.mikoto.api.GroupApi;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.api.MassApi;
import com.s1025.mikoto.api.MaterialApi;
import com.s1025.mikoto.api.MediaApi;
import com.s1025.mikoto.api.MenuApi;
import com.s1025.mikoto.api.PassiveApi;
import com.s1025.mikoto.api.UserApi;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.plugin.IRouter;
import com.s1025.mikoto.util.Dev;

public class Mikoto {
	
	/**
	 * 
	 */
	public static App app;
	
	/**
	 * ����˽�����֤���ֶΣ���ʼ��ʱע�롣
	 */
	public static String token;
	
	/**
	 * 
	 */
	public static Parse parse = new Parse();
	
	public static boolean router(HttpServletRequest req, HttpServletResponse resp){
		return plugin.router.service(req, resp);
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
		public static DatacubeApi datacube = new DatacubeApi();
	}
	
	public static class plugin{
		public static IRouter router = new Router();
	}
	
	/**
	 * ��֤��������ַ��Ч��.
	 * ������Dev�е���֤������
	 * @param req http����
	 * @param resp http��Ӧ
	 * @return �Ƿ����ɹ�
	 * @throws IOException
	 */
	public static boolean validate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		boolean val = Dev.validate(signature, timestamp, nonce, echostr, token);
		if(val) {
			PrintWriter out = resp.getWriter();
			out.print(echostr);
			out.close();
		}
		return val;
	}
	
	/**
	 * ��ʼ��.
	 * ÿ��΢�Ź��ںŶ�����appid��appsecret�����еĵ��ö���Ҫ������������
	 * �˺���ֻ�����ڱ��ز����������á�
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
	 * ��ʼ��.
	 * �ຬ��һ��token���������з�������֤��
	 * @param appid
	 * @param appsecret
	 * @param token
	 */
	public static void build(String appid, String appsecret, String token){
		build(appid, appsecret);
		Mikoto.token = token;
	}
}
