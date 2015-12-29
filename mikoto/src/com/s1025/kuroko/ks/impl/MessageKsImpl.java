package com.s1025.kuroko.ks.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.dao.KfMessageDAO;
import com.s1025.kuroko.dao.RuleDAO;
import com.s1025.kuroko.dao.impl.KfMessageDAOimpl;
import com.s1025.kuroko.dao.impl.RuleDAOimpl;
import com.s1025.kuroko.ks.MessageKs;
import com.s1025.kuroko.ks.Parse;
import com.s1025.kuroko.ks.Passive;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Rule;
import com.s1025.kuroko.model.req.ReqText;
import com.s1025.kuroko.model.MsgType;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.mikoto.Mikoto;

public class MessageKsImpl implements MessageKs{
	KfMessageDAO kfMessageDAO = new KfMessageDAOimpl();
	RuleDAO ruleDAO = new RuleDAOimpl();
	Gson gson = new Gson();
	Parse parse = new Parse();
	Passive passive = new Passive();
	
	
	public boolean router(HttpServletRequest req, HttpServletResponse resp) {
		ReqBase reqBase = parse.getReq(req);
		List<Reply> mateReply = new ArrayList<Reply>();
		
		if(reqBase.getMsgType().equals(MsgType.TEXT)){
			mateReply = matchRule(((ReqText)reqBase).getContent());
		}
		
		try {
			PrintWriter pw = resp.getWriter();
			pw.println("success");
			pw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for(Reply reply:mateReply){
				if(MsgType.TEXT.equals(reply.getType())){
					Kuroko.ks.messageKs.sendText(reqBase.getFromUserName(), "system", reply.getContent());
				} else if(MsgType.IMAGE.equals(reply.getType())){
					Kuroko.ks.messageKs.sendText(reqBase.getFromUserName(), "system", reply.getContent());
				} //else if(MsgType.ACTION.equals(reply.getType())){
					//Kuroko.action.dispose(reqBase, reply.getContent(), resp);
				//}
		}
		
		if(mateReply.size()==0){
			if(reqBase.getMsgType().equals(MsgType.TEXT)){
				ReqText reqText = (ReqText)reqBase;
				KfMessage message = new KfMessage();
				message.setTouser("system");
				message.setFromuser(reqText.getFromUserName());
				message.setMsgtype("text");
				message.setContent(reqText.getContent());
				int r = kfMessageDAO.insert(message);
			}
		}
		
		return false;
	}
	
	
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
			int ri = 0;
			KfMessage message = new KfMessage();
			message.setTouser(to);
			message.setFromuser(from);
			message.setContent(content);
			message.setMsgtype("text");
			if(!"system".equals(from))
				ri = kfMessageDAO.insert(message);
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

	
	/**
	 * 主动发送图片消息.
	 * 将发送图片消息给微信用户，并记录在数据库中。
	 * @param openid
	 * @param content
	 * @return
	 */
	public Result<KfMessage> sendImg(String to, String from, String mediaId, boolean r){
		String re = Mikoto.api.kf.sendCustomImage(to, mediaId);
		if(KuUtil.isResultSuccess(re)){
			int ri = 0;
			KfMessage message = new KfMessage();
			message.setTouser(to);
			message.setFromuser(from);
			message.setContent(mediaId);
			message.setMsgtype("image");
			if(!"system".equals(from))
				kfMessageDAO.insert(message);
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
	public int sendImg(String to, String from, String mediaId) {
		Result<KfMessage> rs = sendImg(to, from, mediaId, true);
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
			if((k.getTotally()==1&&k.getContent().equals(key))||(k.getTotally()==0&&k.getContent().contains(key))){
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
				int x = random.nextInt(list.size());
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


	@Override
	public Result<Rule> addRule(Rule rule, boolean r) {
		int i = ruleDAO.insert(rule);
		if(i>0)
			return new Result<Rule>(0,"ok",rule,null);
		return new Result<Rule>(-2,"数据库错误",null,null);
	}


	@Override
	public int addRule(Rule rule) {
		Result<Rule> rs = addRule(rule, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}




}
