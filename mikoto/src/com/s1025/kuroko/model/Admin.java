package com.s1025.kuroko.model;

public class Admin {
	private String aid;
	private String passwd;
	private String name;
	private String email;
	private String registered;
	private int lv;
	private int status;
	private String openid;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegistered() {
		return registered;
	}
	public void setRegistered(String registered) {
		this.registered = registered;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", passwd=" + passwd + ", name=" + name
				+ ", email=" + email + ", registered=" + registered + ", lv="
				+ lv + ", status=" + status + ", openid=" + openid + "]";
	}
	
	
}
