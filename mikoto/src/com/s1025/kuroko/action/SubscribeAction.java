package com.s1025.kuroko.action;

import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.ks.UserKs;
import com.s1025.kuroko.ks.impl.UserKsImpl;
import com.s1025.kuroko.model.Action;
import com.s1025.kuroko.model.Event;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.req.ReqSubscribe;

public class SubscribeAction implements KurokoAction{

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
		ReqSubscribe rs = (ReqSubscribe)reqBase;
		UserKs userKs = new UserKsImpl();
		if(Event.SUBSCRIBE.equals(rs.getEvent())){
			userKs.pullUser(rs.getFromUserName());
		}
		return false;
	}

}
