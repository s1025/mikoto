package com.s1025.kuroko.module.user;

import java.util.List;

public class OpenidList {
	private List<String> openid;

	public List<String> getOpenid() {
		return openid;
	}

	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "OpenidList [openid=" + openid + "]";
	}

}
