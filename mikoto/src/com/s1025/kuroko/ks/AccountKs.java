package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.AccountUser;
import com.s1025.kuroko.model.Result;

public interface AccountKs {

	public Result<Account> addAccount(String account, String passwd, boolean r);
	public int addAccount(String account, String passwd);
	
	public Result<Account> delAccount(String account, boolean r);
	public int delAccount(String account);
	
	public Result<Account> getAccounts(boolean r);
	public int getAccounts();
	
	public Result<Account> joinAccount(String account, String openid, int lev, int type, boolean r);
	public int joinAccount(String account, String openid, int lev, int type);
	
	public Result<Account> quitAccount(String account, String openid, boolean r);
	public int quitAccount(String account, String openid);
	
	public Result<AccountUser> getAccountUser(String account, String openid, boolean r);
	public AccountUser getAccountUser(String account, String openid);
	
	public Result<Integer> getUserLev(String account, String openid, boolean r);
	public int getUserLev(String account, String openid);
	
	public Result<Integer> getUserType(String account, String openid, boolean r);
	public int getUserType(String account, String openid);
	
}
