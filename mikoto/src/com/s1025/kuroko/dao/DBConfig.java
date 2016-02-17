package com.s1025.kuroko.dao;

public class DBConfig {
	private String url;
	private String user;
	private String passwd;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "DBConfig [url=" + url + ", user=" + user + ", passwd=" + passwd
				+ "]";
	}
	
	
	
}
