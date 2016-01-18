package com.s1025.kuroko.model;

public class AccountUser {
	private int id;
	private String openid;
	private int lev;
	private int type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AccountUser [id=" + id + ", openid=" + openid + ", lev=" + lev + ", type=" + type + "]";
	}
	
	
}
