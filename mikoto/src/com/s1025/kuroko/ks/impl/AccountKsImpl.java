package com.s1025.kuroko.ks.impl;

import com.s1025.kuroko.dao.AccountDAO;
import com.s1025.kuroko.dao.AccountUserDAO;
import com.s1025.kuroko.dao.impl.AccountDAOimpl;
import com.s1025.kuroko.dao.impl.AccountUserDAOimpl;
import com.s1025.kuroko.ks.AccountKs;
import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.AccountUser;
import com.s1025.kuroko.model.Result;

public class AccountKsImpl implements AccountKs{
	AccountDAO accountDAO = new AccountDAOimpl();
	AccountUserDAO accountUserDAO = new AccountUserDAOimpl();

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
		Result<Account> rs = addAccount(account, passwd, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	@Override
	public Result<Account> joinAccount(String account, String openid, int lev, int type, boolean r) {
		Account ao = accountDAO.select(account);
		
		AccountUser accountUser = new AccountUser();
		accountUser.setId(ao.getId());
		accountUser.setOpenid(openid);
		accountUser.setLev(lev);
		accountUser.setType(type);
		int re = accountUserDAO.insert(accountUser);
		
		if(re>0)
			return new Result<Account>(0,"ok",null,null);
		return new Result<Account>(-1,"error",null,null);
	}

	@Override
	public int joinAccount(String account, String openid, int lev, int type) {
		Result<Account> rs = joinAccount(account, openid, lev, type, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	@Override
	public Result<Account> quitAccount(String account, String openid, boolean r) {
		Account ao = accountDAO.select(account);
		int re = accountUserDAO.delete(ao.getId(), openid);
		
		if(re>0)
			return new Result<Account>(0,"ok",null,null);
		return new Result<Account>(-1,"error",null,null);
	}

	@Override
	public int quitAccount(String account, String openid) {
		Result<Account> rs = quitAccount(account, openid, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	@Override
	public Result<Account> delAccount(String account, boolean r) {
		Account ao = accountDAO.select(account);
		accountDAO.delete(ao.getId());
		accountUserDAO.delete(ao.getId());
		return new Result<Account>(0,"ok",null,null);
	}

	@Override
	public int delAccount(String account) {
		Result<Account> rs = delAccount(account, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	@Override
	public Result<Integer> getUserLev(String account, String openid, boolean r) {
		Result<AccountUser> rs = getAccountUser(account, openid, true);
		if(rs.getErrcode()==0){
			new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),rs.getData().getLev(),null);
		}
		return new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),null,null);
	}

	@Override
	public int getUserLev(String account, String openid) {
		Result<Integer> rs = getUserLev(account, openid, true);
		if(rs.getErrcode()==0)
			return rs.getData();
		return 0;
	}

	@Override
	public Result<Integer> getUserType(String account, String openid, boolean r) {
		Result<AccountUser> rs = getAccountUser(account, openid, true);
		if(rs.getErrcode()==0){
			new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),rs.getData().getType(),null);
		}
		return new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),null,null);
	}

	@Override
	public int getUserType(String account, String openid) {
		Result<Integer> rs = getUserType(account, openid, true);
		if(rs.getErrcode()==0)
			return rs.getData();
		return 0;
	}

	@Override
	public Result<AccountUser> getAccountUser(String account, String openid, boolean r) {
		Account ao = accountDAO.select(account);
		AccountUser au = accountUserDAO.select(ao.getId(), openid);
		return new Result<AccountUser>(0, "ok", au, null);
	}

	@Override
	public AccountUser getAccountUser(String account, String openid) {
		Result<AccountUser> rs = getAccountUser(account, openid, true);
		if(rs.getErrcode()==0)
			return rs.getData();
		return new AccountUser();
	}

}
