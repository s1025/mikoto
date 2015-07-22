package com.fkxpjj.mikoto.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Err {
	@JSONField(name="errcode")
	private int errcode;
	
	@JSONField(name="errmsg")
	private String errmsg;
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
