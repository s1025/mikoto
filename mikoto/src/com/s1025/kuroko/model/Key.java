package com.s1025.kuroko.model;

/**
 * �ؼ�����.
 * @author fkxpjj
 *
 */
public class Key {
	/**
	 * �ؼ������ڵĹ���.
	 * �������ݿ���汣�ֹ�����֮�󲻱�֤��������ȷ��
	 */
	private String rname;
	
	private String type;
	
	/**
	 * �ؼ�������.
	 * Ŀǰ��֧��������ʽ�Ĺؼ��֡�
	 */
	private String content;
	
	/**
	 * �Ƿ�ȫƥ��.
	 * ȫƥ��ֻ��������ؼ�����ȫһ���Ż�ƥ��ɹ���δȫƥ��ֻҪ�ؼ��ֳ����������Ｔ��ƥ��ɹ���
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Key [rname=" + rname + ", type=" + type + ", content=" + content + ", totally=" + totally + "]";
	}
	
	
}