package com.s1025.kuroko.model;

/**
 * 规则回复类.
 * @author fkxpjj
 *
 */
public class Reply {
	/**
	 * 回复所在的规则.
	 * 仅在数据库层面保持关联，之后不保证此属性正确。
	 */
	private String rname;
	
	/**
	 * 回复类型.
	 * 不同类型将会以不同方式解析回复内容。
	 * 由ReplyType类决定。
	 */
	private String type;
	
	/**
	 * 回复内容.
	 */
	private String content;
	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Reply [rname=" + rname + ", type=" + type + ", content="
				+ content + "]";
	}
}
