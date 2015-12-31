package com.fkxpjj.demo;

import java.util.Date;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.model.Action;
import com.s1025.kuroko.model.req.ReqBase;

public class TAction implements KurokoAction{

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
		System.out.println("ta");
		Date date = new Date();
		Kuroko.ks.messageKs.sendText(reqBase.getFromUserName(), "system", date.toString());
		return true;
	}

}
