package com.s1025.kuroko.model;

/**
 * ����ظ���.
 * @author fkxpjj
 *
 */
public class Reply {
	/**
	 * �ظ����ڵĹ���.
	 * �������ݿ���汣�ֹ�����֮�󲻱�֤��������ȷ��
	 */
	private String rname;
	
	/**
	 * �ظ�����.
	 * ��ͬ���ͽ����Բ�ͬ��ʽ�����ظ����ݡ�
	 * ��ReplyType�������
	 */
	private String type;
	
	/**
	 * �ظ�����.
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
