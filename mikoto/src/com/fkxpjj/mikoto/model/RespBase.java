package com.fkxpjj.mikoto.model;
/**
 * �ظ���Ϣ�Ļ��࣬������Ϣ���ͼ̳д��ࡣ
 * 
 * @author fkxpjj
 *
 */
public  class RespBase {
	public String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	@Override
	public String toString() {
		return "RespBase [ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + "]";
	}

	
	
}
