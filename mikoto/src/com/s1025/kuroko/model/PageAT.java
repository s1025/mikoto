package com.s1025.kuroko.model;

/**
 * 网页授权时获取access_token时返回的信息
 * @author fkxacg
 *
 */
public class PageAT {
	private String access_token;
	private String refresh_token;
	private String openid;
	private String scope;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	@Override
	public String toString() {
		return "PageAT [access_token=" + access_token + ", refresh_token=" + refresh_token + ", openid=" + openid
				+ ", scope=" + scope + "]";
	}

}
