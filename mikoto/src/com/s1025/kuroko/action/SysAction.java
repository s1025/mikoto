package com.s1025.kuroko.action;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.Action;
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
	public boolean service(ReqBase reqBase, Action action) {
		String type = ReqUtil.getType(reqBase);
		String content = "δ����";
		if(Event.SCAN.equals(type)){
			ReqEventScan scan = (ReqEventScan)reqBase;
			long key = scan.getEventKey();
			String func = QRUtil.getFunc(key);
			if("01".equals(func)){
				Result<Account> rs = Kuroko.ks.accountKs.joinAccount(Integer.parseInt(QRUtil.getPara(key, 1)), scan.getFromUserName(), 0, 0);
				if(rs.getErrcode()==0){
					content = "����Ա�󶨳ɹ�";
				} else {
					content = "����Ա��ʧ��";
				}
			}
		}
		Kuroko.ks.messageKs.sendText(reqBase.getFromUserName(), reqBase.getToUserName(), content);
		return false;
	}

}
