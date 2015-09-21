package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

/**
 * ���򹹽���.
 * ���򹹽����к���һ����������ù����������ɵĶԹ������������á�
 * ÿ��������ֻ�ܹ���һ������
 * @author fkxpjj
 *
 */
public class RuleBuilder {
	private Rule rule = new Rule();
	private List<Key> keys = new ArrayList<Key>();
	private List<Reply> replys = new ArrayList<Reply>();

	/**
	 * Ĭ�Ϲ�����.
	 * ���ûظ�ȫ���������ظ�������������Ϊ�����ȼ�Ϊ10��
	 */
	public RuleBuilder(){
		rule.setRespAll(false);
		rule.setPri(10);
		rule.setNow(false);
		rule.setEnd(false);
	}
	
	/**
	 * ������.
	 * ����һ�����֣����������ʼ������Ĭ�Ϲ�������
	 * @param name ������
	 */
	public RuleBuilder(String name){
		this();
		rule.setName(name);
	}

	/**
	 * ��ӹؼ���.
	 * ����δȫƥ��ķ�ʽ����RuleBuilder addKey(String content, boolean totally)��
	 * @param content �ؼ�������
	 * @return ��������
	 */
	public RuleBuilder addKey(String content){
		return this.addKey(content, false);
	}
	
	/**
	 * ��ӹؼ���.
	 * @param content �ؼ�������
	 * @param totally �Ƿ�ȫƥ��
	 * @return ��������
	 */
	public RuleBuilder addKey(String content, boolean totally){
		Key key = new Key();
		key.setContent(content);
		key.setTotally(totally);
		keys.add(key);
		return this;
	}
	
	/**
	 * ��ӻظ�.
	 * �����ı���ʽ����addReply(int type, String content)��
	 * @param content �ظ�����
	 * @return ��������
	 */
	public RuleBuilder addReply(String content){
		return this.addReply(ReplyType.TEXT, content);
	}
	
	/**
	 * ��ӻظ�.
	 * @param type �ظ����ͣ������Ժ��ַ�ʽ���ûظ����ݣ�ReplyType���ж�����������͡�
	 * @param content �ظ�����
	 * @return ��������
	 */
	public RuleBuilder addReply(int type, String content){
		Reply reply = new Reply();
		reply.setType(type);
		reply.setContent(content);
		replys.add(reply);
		return this;
	}
	
	/**
	 * ��ù����Ĺ������.
	 * @return ����
	 */
	public Rule getRule(){
		rule.setKeys(keys);
		rule.setReplys(replys);
		return rule;
	}
}
