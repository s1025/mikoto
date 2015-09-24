package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	private String name;                                        //������
	private List<Key> keys = new ArrayList<Key>();              //�ؼ����б�
	private List<Reply> replys = new ArrayList<Reply>();        //�ظ��б�
	private boolean respAll;                                    //�ظ�ȫ����
	private int pri;                                            //���ȼ�
	private boolean now;                                        //�����ظ���
	private boolean end;                                        //����������
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
