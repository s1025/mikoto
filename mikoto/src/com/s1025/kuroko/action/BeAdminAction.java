package com.s1025.kuroko.action;

import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.model.Action;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.req.ReqEventScan;

public class BeAdminAction implements KurokoAction{

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
		ReqEventScan scan = (ReqEventScan)reqBase;
		String key = Long.toHexString(scan.getEventKey());
		
		
		
		return false;
	}

}
