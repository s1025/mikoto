package com.fkxpjj.mikoto.model;
/**
 * �ظ���Ϣ�Ļ��࣬������Ϣ���ͼ̳д��ࡣ
 * 
 * @author fkxpjj
 *
 */
public  class ReplyBase {
	public String toUserName;
	private String fromUserName;
	private String createTime;
	private String msgType;
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	
}
