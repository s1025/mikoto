package com.s1025.kuroko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.module.action.Action;
import com.s1025.kuroko.module.kf.KfService;
import com.s1025.kuroko.module.media.MediaService;
import com.s1025.kuroko.module.menu.MenuService;
import com.s1025.kuroko.module.passive.Parse;
import com.s1025.kuroko.module.passive.PassiveService;
import com.s1025.kuroko.module.passive.ReqBuilder;
import com.s1025.kuroko.module.router.IRouter;
import com.s1025.kuroko.module.router.Router;
import com.s1025.kuroko.module.user.UserService;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.util.Dev;

public class Kuroko {
	
	public static class service{
		public static UserService user = new UserService();
		public static MenuService menu = new MenuService();
		public static MediaService media = new MediaService();
		public static KfService kf = new KfService();
		public static PassiveService passive = new PassiveService();
	}
	
	public static class builder{
		public static ReqBuilder req = new ReqBuilder();
	}
	
	public static IRouter router = new Router();
	public static Action action = new Action();
	public static Parse parse = new Parse();
	
	/**
	 * 验证服务器地址有效性.
	 * 将调用Dev中的验证函数。
	 * @param req http请求
	 * @param resp http响应
	 * @return 是否接入成功
	 * @throws IOException
	 */
	public static boolean validate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		boolean val = Mikoto.validate(signature, timestamp, nonce, echostr);
		if(val) {
			PrintWriter out = resp.getWriter();
			out.print(echostr);
			out.close();
		}
		return val;
	}
	
	public static void router(HttpServletRequest req, HttpServletResponse resp){
		router.service(req, resp);
	}
}
