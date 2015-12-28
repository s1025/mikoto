package com.s1025.kuroko.ks.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.gson.Gson;
import com.s1025.kuroko.dao.KfMessageDAO;
import com.s1025.kuroko.dao.RuleDAO;
import com.s1025.kuroko.dao.impl.KfMessageDAOimpl;
import com.s1025.kuroko.dao.impl.RuleDAOimpl;
import com.s1025.kuroko.ks.MessageKs;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Rule;
import com.s1025.mikoto.Mikoto;

public class MessageKsImpl implements MessageKs{
	KfMessageDAO kfMessageDAO = new KfMessageDAOimpl();
	RuleDAO ruleDAO = new RuleDAOimpl();
	Gson gson = new Gson();
	
	/**
	 * 主动发送文本消息.
	 * 将发送文本消息给微信用户，并记录在数据库中。
	 * @param openid
	 * @param content
	 * @return
	 */
	public Result<KfMessage> sendText(String to, String from, String content, boolean r){
		String re = Mikoto.api.kf.sendCustomText(to, content);
		if(KuUtil.isResultSuccess(re)){
			KfMessage message = new KfMessage();
			message.setTouser(to);
			message.setFromuser(from);
			message.setContent(content);
			message.setMsgtype("text");
			int ri = kfMessageDAO.insert(message);
			Result<KfMessage> rs = new Result<KfMessage>();
			rs.setErrcode(0);
			rs.setErrmsg("ok");
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<KfMessage> rs = new Result<KfMessage>(er);
			return rs;
		}
	}


	@Override
	public int sendText(String to, String from, String content) {
		Result<KfMessage> rs = sendText(to, from, content, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}


	@Override
	public Result<Reply> matchRule(String key, boolean r) {
		List<Key> keys = ruleDAO.selectMatchKey(key);
		
		//获得所有匹配规则名
		Set<String> ksets = new HashSet<String>();
		for(Key k:keys){
			if(k.getTotally()==1||(k.getTotally()==0&&k.getContent().contains(key))){
				ksets.add(k.getRname());
			}
		}
		
		//获得reply集合
		Set<Reply> replys = new HashSet<Reply>();
		for(String rname:ksets){
			Rule rule = ruleDAO.selectRuleOnly(rname);
			List<Reply> list = ruleDAO.selectReply(rname);
			if(rule.getRespAll()==1){
				replys.addAll(list);
			}else{
				Random random = new Random();
				int x = random.nextInt()*list.size();
				replys.add(list.get(x));
			}
		}
		
		Result<Reply> rs = new Result<Reply>(0,"ok",null,new ArrayList<Reply>(replys));
		return rs;
	}
	
	@Override
	public List<Reply> matchRule(String key) {
		Result<Reply> rs = matchRule(key, true);
		if(rs.getErrcode()==0)
			return rs.getDatas();
		return new ArrayList<Reply>();
	}

}
