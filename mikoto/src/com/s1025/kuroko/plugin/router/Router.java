package com.s1025.kuroko.plugin.router;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.mikoto.plugin.IRouter;

/**
 * 路由类 提供复杂的关键字回复功能.
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
	 * 获得规则构建器.
	 * 将返回一个新的规则构建器，默认参数查看构建器说明。
	 * @return 规则构建器
	 */
	public RuleBuilder getRuleBuilder(){
		ruleBuilder = new RuleBuilder();
		return ruleBuilder;
	}
	
	/**
	 * 获得规则构建器.
	 * 判断传入参数，为真时返回上一次构建规则的构建器，为假时调用getRuleBuilder()函数。
	 * @param old 是否为旧的构建器
	 * @return 规则构建器
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
	 * 添加规则.
	 * 将添加默认规则构建器中的规则。
	 * @return 本路由
	 */
	public Router addRule(){
		this.rules.add(ruleBuilder.getRule());
		return this;
	}
	
	/**
	 * 添加规则.
	 * 添加指定规则构建器中的规则。
	 * @param ruleBuilder 规则构建器
	 * @return 本路由
	 */
	public Router addRule(RuleBuilder ruleBuilder){
		this.rules.add(ruleBuilder.getRule());
		return this;
	}
	
	/**
	 * 添加规则.
	 * 添加指定的规则对象。
	 * @param rule 规则对象
	 * @return 本路由
	 */
	public Router addRule(Rule rule){
		this.rules.add(rule);
		return this;
	}
}
