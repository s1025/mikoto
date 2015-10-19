package com.s1025.kuroko.module;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
	private int errCode;
	private String errMsg;
	private List<T> data;
	
	public Result() {
		super();
	}
	
	public Result(T e) {
		this.data = new ArrayList<T>();
		this.data.add(e);
		this.errCode = 0;
		this.errMsg = "ok";
	}
	
	public Result(List<T> list) {
		this.data = list;
		this.errCode = 0;
		this.errMsg = "ok";
	}
	
	public Result(ErrResult er){
		this.errCode = Integer.parseInt(er.getErrcode());
		this.errMsg = er.getErrmsg();
		this.data = new ArrayList<T>();
	}

	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [errCode=" + errCode + ", errMsg=" + errMsg + ", data="
				+ data + "]";
	}
	
	public Result<T> addData(T e){
		this.data.add(e);
		return this;
	}
	
}
