package com.s1025.kuroko.model;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	private String name;                                        //������
	private List<Key> keys = new ArrayList<Key>();              //�ؼ����б�
	private List<Reply> replys = new ArrayList<Reply>();        //�ظ��б�
	private boolean respAll;                                    //�ظ�ȫ����
	private int pri;                                            //���ȼ�
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
	public boolean isRespAll() {
		return respAll;
	}
	public void setRespAll(boolean respAll) {
		this.respAll = respAll;
	}
	public void setRespAll(int respAll){
		if(respAll==0)
			this.respAll = false;
		else
			this.respAll = true;
	}
	public int getRespAll(){
		if(respAll)
			return 1;
		else
			return 0;
	}
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
	@Override
	public String toString() {
		return "Rule [name=" + name + ", keys=" + keys + ", replys=" + replys
				+ ", respAll=" + respAll + ", pri=" + pri + "]";
	}
	
}
