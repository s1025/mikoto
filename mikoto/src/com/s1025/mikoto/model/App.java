package com.s1025.mikoto.model;
/**
 * 
 * @author fkxpjj
 *
 */
public class App {
	private String appID;
	private String appSecret;
	
	public App() {
		super();
	}

	public App(String appID, String appSecret) {
		super();
		this.appID = appID;
		this.appSecret = appSecret;
	}
	
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
