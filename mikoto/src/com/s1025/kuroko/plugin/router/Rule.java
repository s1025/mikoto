package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	private String name;                                        //规则名
	private List<Key> keys = new ArrayList<Key>();              //关键字列表
	private List<Reply> replys = new ArrayList<Reply>();        //回复列表
	private boolean respAll;                                    //回复全部吗？
	private int pri;                                            //优先级
	private boolean now;                                        //立即回复吗？
	private boolean end;                                        //立即结束吗？
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Key> getKeys() {
		return keys;
	}
	public void setKeys(List<Key> keys) {
		this.keys = keys;
	}
	public List<Reply> getReplys() {
		return replys;
	}
	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}
	public boolean getRespAll() {
		return respAll;
	}
	public void setRespAll(boolean respAll) {
		this.respAll = respAll;
	}
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
	public boolean getNow() {
		return now;
	}
	public void setNow(boolean now) {
		this.now = now;
	}
	public boolean getEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	
}
