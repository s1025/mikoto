package com.s1025.kuroko.plugin.router;

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
	private int type;
	
	/**
	 * �ظ�����.
	 */
	private String content;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
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
}
