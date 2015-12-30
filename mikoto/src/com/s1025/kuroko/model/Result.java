package com.s1025.kuroko.model;

import java.util.ArrayList;
import java.util.List;


public class Result<T> {
	private int errcode;
	private String errmsg;
	private T data;
	private List<T> datas;
	
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public Result() {
		super();
	}
	public Result(int errcode, String errmsg, T data, List<T> datas) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.data = data;
		this.datas = datas;
	}
	public Result(ErrResult er){
		this.errcode = Integer.parseInt(er.getErrcode());
		this.errmsg = er.getErrmsg();
	}
	@Override
	public String toString() {
		return "Result [errcode=" + errcode + ", errmsg=" + errmsg + ", data=" + data + ", datas=" + datas + "]";
	}
	
	
	
}
