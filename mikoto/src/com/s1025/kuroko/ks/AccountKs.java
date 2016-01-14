package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Account;
import com.s1025.kuroko.model.Result;

public interface AccountKs {

	public Result<Account> addAccount(String account, String passwd, boolean r);
	public int addAccount(String account, String passwd);
	
	public Result<Account> joinAccount();
	
}
