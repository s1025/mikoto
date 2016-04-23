package com.s1025.kuroko.action;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.DBConfig;
import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.Event;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.req.ReqEventScan;
import com.s1025.kuroko.util.QRUtil;
import com.s1025.kuroko.util.ReqUtil;

public class SysAction implements KurokoAction{

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
		String content = "未处理";
		if(Event.SCAN.equals(type)){
			ReqEventScan scan = (ReqEventScan)reqBase;
			long key = scan.getEventKey();
			String func = QRUtil.getFunc(key);
			if("01".equals(func)){
				Result<Account> rs = Kuroko.ks.accountKs.joinAccount(Integer.parseInt(QRUtil.getPara(key, 1)), scan.getFromUserName(), 0, 0);
				if(rs.getErrcode()==0){
					content = "管理员绑定成功";
				} else {
					content = "管理员绑定失败";
				}
			} else if ("02".equals(func)){
				String openid = reqBase.getFromUserName();
				String account = QRUtil.getPara(key, 1);
				Kuroko.ks.accountKs.getAccountUser(account, openid);
			}
		}
		Kuroko.ks.messageKs.sendText(reqBase.getFromUserName(), reqBase.getToUserName(), content);
		return false;
	}
	
	public Result<DBConfig> setDB(DBConfig db){
		if(!db.getUrl().startsWith("jdbc")){
			db.setUrl("jdbc:mysql://127.0.0.1:3306/"+db.getUrl()+"?characterEncoding=UTF-8");
		}
		Kuroko.ks.configKs.setDB(db, null);
		Kuroko.ks.configKs.pushDB(null);
		return new Result<DBConfig>(0, "ok", null, null);
	}
	
	public Result<DBConfig> getDB(){
		return null;
	}

}
