package com.fkxpjj.mikoto.model;
/**
 * 
 * @author fkxpjj
 *
 */
public class App {
	private String appID;
	private String appSecret;
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	@Override
	public String toString() {
		return "App [appID=" + appID + ", appSecret=" + appSecret + "]";
	}
	
	
	
}
