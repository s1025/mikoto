package com.s1025.kuroko.action;

import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.ks.UserKs;
import com.s1025.kuroko.ks.impl.UserKsImpl;
import com.s1025.kuroko.model.Action;
import com.s1025.kuroko.model.Event;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.req.ReqUnSubscribe;

public class UnSubscribeAction implements KurokoAction{

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
		ReqUnSubscribe rs = (ReqUnSubscribe)reqBase;
		UserKs userKs = new UserKsImpl();
		if(Event.UNSUBSCRIBE.equals(rs.getEvent())){
			userKs.delUser(rs.getFromUserName());
		}
		return false;
	}

}
