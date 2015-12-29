package com.s1025.kuroko.ks;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.MsgType;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Rule;


/**
 * 规则构建器.
 * 规则构建器中含有一个规则对象，用构建器可轻松的对规则进行相关设置。
 * 每个构建器只能构建一个对象。
 * @author fkxpjj
 *
 */
public class RuleBuilder {
	private Rule rule = new Rule();
	private List<Key> keys = new ArrayList<Key>();
	private List<Reply> replys = new ArrayList<Reply>();

	/**
	 * 默认构造器.
	 * 设置回复全部为否。
	 */
	public RuleBuilder(){
		rule.setRespAll(false);
	}
	
	/**
	 * 构造器.
	 * 接收一个名字，其余变量初始化交给默认构造器。
	 * @param name 规则名
	 */
	public RuleBuilder(String name){
		this();
		rule.setName(name);
	}

	/**
	 * 添加关键字.
	 * 将以未全匹配的方式调用RuleBuilder addKey(String content, boolean totally)。
	 * @param content 关键字内容
	 * @return 本构建器
	 */
	public RuleBuilder addKey(String content){
		return this.addKey(content, false);
	}
	
	/**
	 * 添加关键字.
	 * @param content 关键字内容
	 * @param totally 是否全匹配
	 * @return 本构建器
	 */
	public RuleBuilder addKey(String content, boolean totally){
		Key key = new Key();
		key.setContent(content);
		key.setTotally(totally);
		keys.add(key);
		return this;
	}
	
	/**
	 * 添加回复.
	 * 将以文本形式调用addReply(int type, String content)。
	 * @param content 回复内容
	 * @return 本构建器
	 */
	public RuleBuilder addReply(String content){
		return this.addReply(MsgType.TEXT, content);
	}
	
	/**
	 * 添加回复.
	 * @param type 回复类型，决定以何种方式调用回复内容，ReplyType类中定义了相关类型。
	 * @param content 回复内容
	 * @return 本构建器
	 */
	public RuleBuilder addReply(String type, String content){
		Reply reply = new Reply();
		reply.setType(type);
		reply.setContent(content);
		replys.add(reply);
		return this;
	}
	
	/**
	 * 设置规则名.
	 * @param name 规则名
	 * @return 本构建器
	 */
	public RuleBuilder setName(String name){
		rule.setName(name);
		return this;
	}
	
	/**
	 * 设置是否回复全部.
	 * 默认为否。
	 * @param respAll 是否回复全部
	 * @return 本构建器
	 */
	public RuleBuilder setRespAll(boolean respAll){
		rule.setRespAll(respAll);
		return this;
	}
	
	
	/**
	 * 使用自己的key列表.
	 * @param keys key列表
	 * @return 本构建器
	 */
	public RuleBuilder setKeys(List<Key> keys){
		this.keys = keys;
		return this;
	}
	
	/**
	 * 使用自己的reply列表.
	 * @param replys reply列表
	 * @return 本构建器
	 */
	public RuleBuilder setReplys(List<Reply> replys){
		this.replys = replys;
		return this;
	}
	
	/**
	 * 更改是否回复全部.
	 * @return 本构建器
	 */
	public RuleBuilder changeRespAll(){
		rule.setRespAll(!rule.isRespAll());
		return this;
	}
	


	
	/**
	 * 获得构建的规则对象.
	 * @return 规则
	 */
	public Rule getRule(){
		rule.setKeys(keys);
		rule.setReplys(replys);
		return rule;
	}
}
