package com.s1025.kuroko.action;

import javax.servlet.http.HttpSession;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.Event;
import com.s1025.kuroko.model.QRCode;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.req.ReqEventScan;
import com.s1025.kuroko.util.QRUtil;
import com.s1025.kuroko.util.ReqUtil;

public class AccountAction implements KurokoAction{

	public static String BLOCK = "01";
	
	public static String SIGNINCODE = "01";
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean service(ReqBase reqBase) {
		String type = ReqUtil.getType(reqBase);
		if(Event.SCAN.equals(type)){
			ReqEventScan scan = (ReqEventScan)reqBase;
			String func = QRUtil.getFunc(scan.getEventKey());
			if("01".equals(func)){
				signin(scan);
			}
		}
		return false;
	}
	
	//»ñµÃ¶þÎ¬ÂëµÇÂ¼Ê±µÄ¶þÎ¬Âë
	public Result<QRCode> getSigninCode(String account, String passwd){
		Result<Account> rs = Kuroko.ks.accountKs.getAccount(account);
		if(rs.getErrcode()!=0)
			return new Result<QRCode>(rs);
		else if(!rs.getData().getPasswd().equals(passwd))
			return new Result<QRCode>(-10,"ÃÜÂë´íÎó",null,null);
		String aid = rs.getData().getId()+"";
		if(aid.length()<2)
			aid = "0"+aid;
		Result<QRCode> rs2 = Kuroko.ks.qrcode.addQRCode(300, BLOCK+SIGNINCODE+aid+"00");
		return rs2;
	}
	
	//ÓÃ¶þÎ¬ÂëÉ¨ÂëµÇÂ¼
	public Result<QRCode> signin(ReqEventScan scan){
		
		String aid = QRUtil.getPara(scan.getEventKey(), 1);
		
		Result<Account> rs = Kuroko.ks.accountKs.getAccount(Integer.parseInt(aid));
		if(rs.getErrcode()!=0)
			return new Result<QRCode>(rs);
		
		HttpSession session = scan.getKurokoContext().getHttpSession();
		session.setAttribute("openid", scan.getFromUserName());
		
		Kuroko.ks.messageKs.sendText(scan.getFromUserName(), scan.getToUserName(), "µÇÂ¼³É¹¦");
		
		return new Result<QRCode>(0,"ok",null,null);
	}

}
