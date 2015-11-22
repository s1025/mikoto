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
 * ·���� �ṩ���ӵĹؼ��ֻظ�����.
 * ����һ�������б��һ��Ĭ�Ϲ��򹹽�����
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
				//�ж�ƥ���Ƿ�ɹ�
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
		ruleDAO.insert(ruleBuilder.getRule());
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
		ruleDAO.insert(ruleBuilder.getRule());
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
		ruleDAO.insert(ruleBuilder.getRule());
		return this;
	}
	
}
