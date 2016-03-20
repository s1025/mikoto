package com.s1025.kuroko.ks.impl;

import java.util.List;

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
	public Result<Account> addAccount(String account, String passwd) {
		Account ao = new Account();
		
		ao.setAccount(account);
		ao.setPasswd(passwd);
		
		int re = accountDAO.insert(ao);
		if(re>0)
			return new Result<Account>(0,"ok",ao,null);
		return new Result<Account>(-1,"error",null,null);
	}

	@Override
	public Result<Account> joinAccount(String account, String openid, int lev, int type) {
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
	public Result<Account> joinAccount(int aid, String openid, int lev, int type) {
		AccountUser accountUser = new AccountUser();
		accountUser.setId(aid);
		accountUser.setOpenid(openid);
		accountUser.setLev(lev);
		accountUser.setType(type);
		int re = accountUserDAO.insert(accountUser);
		
		if(re>0)
			return new Result<Account>(0,"ok",null,null);
		return new Result<Account>(-1,"error",null,null);
	}

	@Override
	public Result<Account> quitAccount(String account, String openid) {
		Account ao = accountDAO.select(account);
		int re = accountUserDAO.delete(ao.getId(), openid);
		
		if(re>0)
			return new Result<Account>(0,"ok",null,null);
		return new Result<Account>(-1,"error",null,null);
	}

	@Override
	public Result<Account> delAccount(String account) {
		Account ao = accountDAO.select(account);
		accountDAO.delete(ao.getId());
		accountUserDAO.delete(ao.getId());
		return new Result<Account>(0,"ok",null,null);
	}

	@Override
	public Result<Integer> getUserLev(String account, String openid) {
		Result<AccountUser> rs = getAccountUser(account, openid);
		if(rs.getErrcode()==0){
			new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),rs.getData().getLev(),null);
		}
		return new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),null,null);
	}

	@Override
	public Result<Integer> getUserType(String account, String openid) {
		Result<AccountUser> rs = getAccountUser(account, openid);
		if(rs.getErrcode()==0){
			new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),rs.getData().getType(),null);
		}
		return new Result<Integer>(rs.getErrcode(), rs.getErrmsg(),null,null);
	}

	@Override
	public Result<AccountUser> getAccountUser(String account, String openid) {
		Account ao = accountDAO.select(account);
		AccountUser au = accountUserDAO.select(ao.getId(), openid);
		return new Result<AccountUser>(0, "ok", au, null);
	}

	@Override
	public Result<Account> getAccount(String accounts){
		Account account = accountDAO.select(accounts);
		if(account.getId()<1){
			return new Result<Account>(-10,"没有此账号",null,null);
		}
		return new Result<Account>(0,"ok",account,null);
	}
	
	@Override
	public Result<Account> getAccounts() {
		List<Account> re = accountDAO.select();
		if(re.size()>0)
			return new Result<Account>(0,"ok",null,re);
		return new Result<Account>(-1,"error",null,null);
	}

	@Override
	public Result<AccountUser> checkAccountUser(int aid, String passwd, String openid) {
		AccountUser au = accountUserDAO.select(aid, openid);
		if(au.getId()==0){
			return new Result<AccountUser>(-10,"没有登录权限",null,null);
		}
		return new Result<AccountUser>(0, "ok", au, null);
	}

	@Override
	public Result<Account> getAccount(int aid) {
		Account account = accountDAO.select(aid);
		if(account.getId()<1){
			return new Result<Account>(-10,"没有此账号",null,null);
		}
		return new Result<Account>(0,"ok",account,null);
	}

}
