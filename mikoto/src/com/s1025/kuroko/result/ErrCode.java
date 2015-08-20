package com.s1025.kuroko.result;

public class ErrCode extends ResultBase{
	private String errcode;
	private String errmsg;
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	@Override
	public String toString() {
		return "ErrCode [errcode=" + errcode + ", errmsg=" + errmsg
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
