package com.s1025.kuroko.module.account;

public class AccountService {
	AccountDAO accountDAO = new AccountDAOimpl();
	
	public int getPeopleLevel(String openid){
		String uid = accountDAO.selectPeopleUid(openid);
		if("".equals(uid)){
			return 0;
		}
		Account account = accountDAO.select(uid);
		if(account.getUid().equals("")){
			return 0;
		} else {
			return account.getLevel();
		}
	}
}
