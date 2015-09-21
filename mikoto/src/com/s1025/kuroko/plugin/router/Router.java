package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.mikoto.plugin.IRouter;

/**
 * ·���� �ṩ���ӵĹؼ��ֻظ�����.
 * 
 * @author fkxpjj
 *
 */
public class Router implements IRouter{
	private List<Rule> rules = new ArrayList<Rule>();
	private RuleBuilder ruleBuilder;

	@Override
	public boolean service(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * ��ù��򹹽���.
	 * ������һ���µĹ��򹹽�����Ĭ�ϲ����鿴������˵����
	 * @return ���򹹽���
	 */
	public RuleBuilder getRuleBuilder(){
		ruleBuilder = new RuleBuilder();
		return ruleBuilder;
	}
	
	/**
	 * ��ù��򹹽���.
	 * �жϴ��������Ϊ��ʱ������һ�ι�������Ĺ�������Ϊ��ʱ����getRuleBuilder()������
	 * @param old �Ƿ�Ϊ�ɵĹ�����
	 * @return ���򹹽���
	 */
	public RuleBuilder getRuleBuilder(boolean old){
		if(old)
			if(null!=ruleBuilder)
				return ruleBuilder;
			else return this.getRuleBuilder();
		else 
			return this.getRuleBuilder();
	}
	
	/**
	 * ��ӹ���.
	 * �����Ĭ�Ϲ��򹹽����еĹ���
	 * @return ��·��
	 */
	public Router addRule(){
		this.rules.add(ruleBuilder.getRule());
		return this;
	}
	
	/**
	 * ��ӹ���.
	 * ���ָ�����򹹽����еĹ���
	 * @param ruleBuilder ���򹹽���
	 * @return ��·��
	 */
	public Router addRule(RuleBuilder ruleBuilder){
		this.rules.add(ruleBuilder.getRule());
		return this;
	}
	
	/**
	 * ��ӹ���.
	 * ���ָ���Ĺ������
	 * @param rule �������
	 * @return ��·��
	 */
	public Router addRule(Rule rule){
		this.rules.add(rule);
		return this;
	}
}
