package com.s1025.kuroko.plugin.router;

/**
 * 关键字类.
 * @author fkxpjj
 *
 */
public class Key {
	/**
	 * 关键字所在的规则.
	 * 仅在数据库层面保持关联，之后不保证此属性正确。
	 */
	private String rname;
	
	/**
	 * 关键字内容.
	 * 目前仅支持文字形式的关键字。
	 */
	private String content;
	
	/**
	 * 是否全匹配.
	 * 全匹配只有输入与关键字完全一样才会匹配成功，未全匹配只要关键字出现在输入里即可匹配成功。
	 */
	private boolean totally;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isTotally() {
		return totally;
	}
	public void setTotally(boolean totally) {
		this.totally = totally;
	}
	public int getTotally(){
		if(totally) return 1;
		else return 0;
	}
	public void setTotally(int totally) {
		if(totally==1)
			this.totally = true;
		else
			this.totally = false;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
}
