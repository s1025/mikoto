package com.s1025.kuroko.module.router;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.module.passive.MsgType;
import com.s1025.kuroko.module.passive.req.ReqBase;
import com.s1025.kuroko.module.passive.req.ReqText;

/**
 * 路由类 提供复杂的关键字回复功能.
 * 包含一个规则列表和一个默认规则构建器。
 * @author fkxpjj
 *
 */
public class Router implements IRouter{
	private List<Rule> rules = new ArrayList<Rule>();
	private RuleBuilder ruleBuilder;
	private RuleDAO ruleDAO = new RuleDAOimpl();

	@Override
	public boolean service(HttpServletRequest req, HttpServletResponse resp) {
		ReqBase reqBase = Kuroko.parse.getReq(req);
		List<Reply> mateReply = mate(reqBase);
		
		for(Reply reply:mateReply){
			try{
				if(MsgType.TEXT.equals(reply.getType())){
					Kuroko.service.passive.sendRespText(reqBase, reply.getContent(), resp);
				} else if(MsgType.IMAGE.equals(reply.getType())){
					Kuroko.service.passive.sendRespImg(reqBase, reply.getContent(), resp);
				} else if(MsgType.VOICE.equals(reply.getType())){
					Kuroko.service.passive.sendRespVoice(reqBase, reply.getContent(), resp);
				}
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public List<Reply> mate(ReqBase reqBase){
		List<Rule> mateRule = new ArrayList<Rule>();
		List<Reply> mateReply = new ArrayList<Reply>();
		String reqKey = "";
		if(reqBase.getMsgType().equals(MsgType.TEXT)){
			ReqText reqText = (ReqText)reqBase;
			reqKey = reqText.getContent();
		}
		
		for(Rule rule:rules){
			List<Key> keys = rule.getKeys();
			
			for(Key key:keys){
				//判断匹配是否成功
				if( key.isTotally()&&reqKey.equals(key.getContent()) 
						|| (!(key.isTotally())&&key.getContent().contains(reqKey))){
					mateRule.add(rule);
					break;
				}
			}
			
		}
		
		for(Rule rule:mateRule){
			List<Reply> replys = rule.getReplys();
			if(rule.isRespAll()){
				mateReply.addAll(replys);
			} else {
				int i = new Random().nextInt(replys.size()-1) + 1; 
				mateReply.add(replys.get(i-1));
			}
		}
		
		return mateReply;
	}
	
	public void send(List<Reply> replys, boolean respAll){
		
	}

	@Override
	public void init() {
		rules = ruleDAO.selectAll();
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
		ruleDAO.insert(ruleBuilder.getRule());
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
		ruleDAO.insert(ruleBuilder.getRule());
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
		ruleDAO.insert(ruleBuilder.getRule());
		return this;
	}
	
}
