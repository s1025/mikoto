package com.s1025.kuroko.module.account;

public class Account {
	private String uid;
	private String upw;
	private int level;          //�˺ŵȼ���1Ϊ��ͨ������Ա��2Ϊ����Ա��3Ϊ��߹���Ա
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Account [uid=" + uid + ", upw=" + upw + ", level=" + level + "]";
	}

}
