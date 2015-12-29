package com.s1025.kuroko.ks;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.MsgType;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Rule;


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
	 * ���ûظ�ȫ��Ϊ��
	 */
	public RuleBuilder(){
		rule.setRespAll(false);
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
		return this.addReply(MsgType.TEXT, content);
	}
	
	/**
	 * ��ӻظ�.
	 * @param type �ظ����ͣ������Ժ��ַ�ʽ���ûظ����ݣ�ReplyType���ж�����������͡�
	 * @param content �ظ�����
	 * @return ��������
	 */
	public RuleBuilder addReply(String type, String content){
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
		rule.setRespAll(!rule.isRespAll());
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
