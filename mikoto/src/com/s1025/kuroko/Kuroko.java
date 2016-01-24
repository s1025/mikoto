package com.s1025.kuroko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.ks.AccountKs;
import com.s1025.kuroko.ks.MediaKs;
import com.s1025.kuroko.ks.MenuKs;
import com.s1025.kuroko.ks.MessageKs;
import com.s1025.kuroko.ks.QRCodeKs;
import com.s1025.kuroko.ks.UserKs;
import com.s1025.kuroko.ks.impl.AccountKsImpl;
import com.s1025.kuroko.ks.impl.MediaKsImpl;
import com.s1025.kuroko.ks.impl.MenuKsImpl;
import com.s1025.kuroko.ks.impl.MessageKsImpl;
import com.s1025.kuroko.ks.impl.QRCodeKsImpl;
import com.s1025.kuroko.ks.impl.UserKsImpl;
import com.s1025.mikoto.Mikoto;

public class Kuroko {
	
	public static String ACTIONPATH;
	
	public static class ks{
		public static AccountKs account = new AccountKsImpl();
		public static UserKs userKs = new UserKsImpl();
		public static MediaKs mediaKs = new MediaKsImpl();
		public static MessageKs messageKs = new MessageKsImpl();
		public static MenuKs menuKs = new MenuKsImpl();
		public static QRCodeKs qrcode = new QRCodeKsImpl();
	}
	
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
		Kuroko.ks.messageKs.router(req, resp);
	}
}
