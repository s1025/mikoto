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
	 * ���ù�����.
	 * @param name ������
	 * @return ��������
	 */
	public RuleBuilder setName(String name){
		rule.setName(name);
		return this;
	}
	
	/**
	 * �����Ƿ�ظ�ȫ��.
	 * Ĭ��Ϊ��
	 * @param respAll �Ƿ�ظ�ȫ��
	 * @return ��������
	 */
	public RuleBuilder setRespAll(boolean respAll){
		rule.setRespAll(respAll);
		return this;
	}
	
	/**
	 * �������ȼ�.
	 * Ĭ��Ϊ10��
	 * @param pri ���ȼ�
	 * @return ��������
	 */
	public RuleBuilder setPri(int pri){
		rule.setPri(pri);
		return this;
	}
	
	/**
	 * �����Ƿ������ظ�.
	 * Ĭ��Ϊ��
	 * @param now �Ƿ������ظ�
	 * @return ��������
	 */
	public RuleBuilder setNow(boolean now){
		rule.setNow(now);
		return this;
	}
	
	/**
	 * �����Ƿ���������.
	 * Ĭ��Ϊ��
	 * @param end �Ƿ���������
	 * @return ��������
	 */
	public RuleBuilder setEnd(boolean end){
		rule.setEnd(end);
		return this;
	}
	
	/**
	 * ʹ���Լ���key�б�.
	 * @param keys key�б�
	 * @return ��������
	 */
	public RuleBuilder setKeys(List<Key> keys){
		this.keys = keys;
		return this;
	}
	
	/**
	 * ʹ���Լ���reply�б�.
	 * @param replys reply�б�
	 * @return ��������
	 */
	public RuleBuilder setReplys(List<Reply> replys){
		this.replys = replys;
		return this;
	}
	
	/**
	 * �����Ƿ�ظ�ȫ��.
	 * @return ��������
	 */
	public RuleBuilder changeRespAll(){
		rule.setRespAll(!rule.getRespAll());
		return this;
	}
	
	/**
	 * �����Ƿ������ظ�.
	 * @return ��������
	 */
	public RuleBuilder changeNow(){
		rule.setNow(!rule.getNow());
		return this;
	}
	
	/**
	 * �����Ƿ���������.
	 * @return ����������
	 */
	public RuleBuilder changeEnd(){
		rule.setEnd(!rule.getEnd());
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
