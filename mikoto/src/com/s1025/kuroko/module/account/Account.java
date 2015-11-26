package com.s1025.kuroko.module.account;

public class Account {
	private String uid;
	private String upw;
	private int level;          //账号等级，1为普通工作人员，2为管理员，3为最高管理员
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Account [uid=" + uid + ", upw=" + upw + ", level=" + level + "]";
	}

}
