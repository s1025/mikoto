package com.s1025.kuroko.ks.impl;

import com.s1025.kuroko.dao.AccountDAO;
import com.s1025.kuroko.dao.impl.AccountDAOimpl;
import com.s1025.kuroko.ks.AccountKs;
import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.Result;

public class AccountKsImpl implements AccountKs{
	AccountDAO accountDAO = new AccountDAOimpl();

	@Override
	public Result<Account> addAccount(String account, String passwd, boolean r) {
		Account ao = new Account();
		
		ao.setAccount(account);
		ao.setPasswd(passwd);
		
		int re = accountDAO.insert(ao);
		if(re>0)
			return new Result<Account>(0,"ok",ao,null);
		return new Result<Account>(-1,"error",null,null);
	}
	
	@Override
	public int addAccount(String account, String passwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result<Account> joinAccount() {
		// TODO Auto-generated method stub
		return null;
	}



}
