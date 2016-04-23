package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.AccountUser;
import com.s1025.kuroko.model.Result;

public interface AccountKs {

	public Result<Account> addAccount(String account, String passwd);	
	public Result<Account> delAccount(String account);
	public Result<Account> getAccount(String account);
	public Result<Account> getAccount(int aid);
	public Result<Account> getAccounts();
	
	public Result<Account> joinAccount(String account, String openid, int lev, int type);
	public Result<Account> joinAccount(int aid, String openid, int lev, int type);
	public Result<Account> quitAccount(String account, String openid);
	public Result<AccountUser> getAccountUser(String account, String openid);
	public Result<Integer> getUserLev(String account, String openid);
	public Result<Integer> getUserType(String account, String openid);
	
	public Result<AccountUser> checkAccountUser(int aid, String openid);
	
}
