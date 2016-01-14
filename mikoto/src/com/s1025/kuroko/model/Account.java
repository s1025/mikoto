package com.s1025.kuroko.model;

public class Account {
	private int id;
	private String account;
	private String passwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", passwd=" + passwd + "]";
	}
	
	
}
