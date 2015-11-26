package com.s1025.kuroko.module.account.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.module.account.Account;
import com.s1025.kuroko.module.account.AccountDAO;
import com.s1025.kuroko.module.account.AccountDAOimpl;
import com.s1025.kuroko.module.action.IAction;
import com.s1025.kuroko.module.passive.req.ReqText;

public class CheckAccount implements IAction{
	AccountDAO accountDAO = new AccountDAOimpl();
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean service(ReqText reqText, HttpServletResponse resp) {
		String openid = reqText.getFromUserName();
		int level = Kuroko.service.account.getPeopleLevel(openid);
		String re = "";
		if(level == 3){
			List<Account> list= accountDAO.selectAll();
			for(Account account : list){
				re += account.getUid() + " " + account.getLevel() + "\n";
			}
		} else {
			re = "您的权限不够";
		}
		
		try {
			Kuroko.service.passive.sendRespText(reqText, re, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

}
