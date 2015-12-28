package com.s1025.kuroko.model;

public class KfMessage {
	private int kmid;
	private String touser;
	private String fromuser;
	private String msgtype;
	private String content;
	private String date;
	public int getKmid() {
		return kmid;
	}
	public void setKmid(int kmid) {
		this.kmid = kmid;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "KfMessage [kmid=" + kmid + ", touser=" + touser + ", fromuser=" + fromuser + ", msgtype=" + msgtype
				+ ", content=" + content + ", date=" + date + "]";
	}

	
	
}
