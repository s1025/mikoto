package com.s1025.kuroko.module.kf;

public class KfMessage {
	private int kmid;
	private String touser;
	private String msgtype;
	private String content;
	private String media_id;
	private String date;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
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
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public int getKmid() {
		return kmid;
	}
	public void setKmid(int kmid) {
		this.kmid = kmid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "KfMessage [kmid=" + kmid + ", touser=" + touser + ", msgtype="
				+ msgtype + ", content=" + content + ", media_id=" + media_id
				+ ", date=" + date + "]";
	}
	
	
}
