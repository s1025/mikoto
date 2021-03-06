package com.s1025.kuroko.model.req;

import com.s1025.kuroko.model.KurokoContext;

public class ReqBase {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;
	private String MsgId;
	private KurokoContext kurokoContext;
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
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public KurokoContext getKurokoContext() {
		return kurokoContext;
	}
	public void setKurokoContext(KurokoContext kurokoContext) {
		this.kurokoContext = kurokoContext;
	}
	@Override
	public String toString() {
		return "ReqBase [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime=" + CreateTime
				+ ", MsgType=" + MsgType + ", MsgId=" + MsgId + ", kurokoContext=" + kurokoContext + "]";
	}
}
