package com.s1025.kuroko.model;

public class QRCode {
	private String ticket;
	private String url;
	private int expireSeconds;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getExpireSeconds() {
		return expireSeconds;
	}
	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	@Override
	public String toString() {
		return "QRCode [ticket=" + ticket + ", url=" + url + ", expireSeconds=" + expireSeconds + "]";
	}

	
}
