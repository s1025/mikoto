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
import com.s1025.kuroko.ks.ActionCenter;
import com.s1025.kuroko.ks.MessageKs;
import com.s1025.kuroko.ks.Parse;
import com.s1025.kuroko.ks.Passive;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.Event;
import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Rule;
import com.s1025.kuroko.model.req.ReqText;
import com.s1025.kuroko.model.MsgType;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.req.ReqEvent;
import com.s1025.kuroko.model.req.ReqEventClick;
import com.s1025.kuroko.model.req.ReqEventScan;
import com.s1025.mikoto.Mikoto;

public class MessageKsImpl implements MessageKs{
	KfMessageDAO kfMessageDAO = new KfMessageDAOimpl();
	RuleDAO ruleDAO = new RuleDAOimpl();
	Gson gson = new Gson();
	Parse parse = new Parse();
	Passive passive = new Passive();
	
	
	public boolean router(HttpServletRequest req, HttpServletResponse resp) {
		
		ReqBase reqBase = parse.getReq(req);
		boolean d = false;
		
		//先返回success，再处理请求
		try {
			PrintWriter pw = resp.getWriter();
			pw.println("success");
			pw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//获得请求key
		Key key = filter(req, reqBase);
		//从数据库中匹配响应
		List<Reply> mateReply = match(key.getType(), key.getContent());
		if(mateReply.size()==0){
			d = true;
			mateReply = match("system", "default");
		}
		
		//处理响应
		outcome(mateReply, reqBase, d);
		
		return false;
	}
	
	public Key filter(HttpServletRequest req, ReqBase reqBase){
		Key key = new Key();
		
		if(reqBase.getMsgType().equals(MsgType.TEXT)){
			ReqText reqText = (ReqText)reqBase;
			key.setType("text");
			key.setContent(reqText.getContent());
		}else if(reqBase.getMsgType().equals(MsgType.EVENT)){
			ReqEvent reqEvent = (ReqEvent) reqBase;
			if(Event.CLICK.equals(reqEvent.getEvent())){
				ReqEventClick click = (ReqEventClick)reqEvent;
				key.setType("button");
				key.setContent(click.getEventKey());
			} else if(Event.SCAN.equals(reqEvent.getEvent())){
				ReqEventScan scan = (ReqEventScan)reqEvent;
				key.setType("qrcode");
				
				String skey = scan.getHexKey();
				skey = skey.substring(0, 2);
				
				key.setContent(skey);
			} else if(Event.SUBSCRIBE.equals(reqEvent.getEvent())){
				key.setType("system");
				key.setContent("subscribe");
			} else if(Event.UNSUBSCRIBE.equals(reqEvent.getEvent())){
				key.setType("system");
				key.setContent("unsubscribe");
			} else {
				key.setType("system");
				key.setContent("default");
			}
		} 
		
		return key;
	}
	
	//@Override
	public Result<Reply> match(String type, String key, boolean r) {
		List<Key> keys = ruleDAO.selectMatchKey(type, key);
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
	
	//@Override
	public List<Reply> match(String type, String key) {
		Result<Reply> rs = match(type, key, true);
		if(rs.getErrcode()==0)
			return rs.getDatas();
		return new ArrayList<Reply>();
	}
	
	public void outcome(List<Reply> replys, ReqBase reqBase, boolean d){
		ActionCenter ac = new ActionCenter();
		for(Reply reply:replys){
			if(MsgType.TEXT.equals(reply.getType())){
				Kuroko.ks.messageKs.sendText(reqBase.getFromUserName(), "system", reply.getContent());
			} else if(MsgType.NEWS.equals(reply.getType())){
				Kuroko.ks.messageKs.sendNews(reqBase.getFromUserName(), "system", reply.getContent());
			} else if(MsgType.ACTION.equals(reply.getType())){
				ac.dispose(reqBase, reply.getContent());
			}
		}
	
		if(d){
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
	public Result<KfMessage> sendNews(String to, String from, String mediaId, boolean r) {
		String re = Mikoto.api.kf.sendCustomNews(to, mediaId);
		if(KuUtil.isResultSuccess(re)){
			int ri = 0;
			KfMessage message = new KfMessage();
			message.setTouser(to);
			message.setFromuser(from);
			message.setContent(mediaId);
			message.setMsgtype("news");
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
	public int sendNews(String to, String from, String mediaId) {
		Result<KfMessage> rs = sendNews(to, from, mediaId, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	
	


	@Override
	public Result<Rule> addRule(Rule rule) {
		int i = ruleDAO.insert(rule);
		if(i>0)
			return new Result<Rule>(0,"ok",rule,null);
		return new Result<Rule>(-2,"数据库错误",null,null);
	}
	
	@Override
	public Result<Rule> delRule(String name) {
		int i = ruleDAO.delete(name);
		if(i>0)
			return new Result<Rule>(0,"ok",null,null);
		return new Result<Rule>(-2,"数据库错误",null,null);
	}

	@Override
	public Result<Rule> getRule() {
		List<Rule> rules = ruleDAO.selectAll();
		if(rules.size()>0)
			return new Result<Rule>(0,"ok",null,rules);
		return new Result<Rule>(-2,"数据库错误",null,null);
	}
	
	@Override
	public Result<KfMessage> sendAllText(int groupId, String content, boolean r) {
		String re = Mikoto.api.mass.sendAll("true", groupId, "text", content);
		if(KuUtil.isResultSuccess(re)){
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
	public int sendAllText(int groupId, String content) {
		Result<KfMessage> rs = sendAllText(groupId, content, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}


	@Override
	public Result<KfMessage> sendAllNews(int groupId, String mediaId, boolean r) {
		String re = Mikoto.api.mass.sendAll("true", groupId, "news", mediaId);
		if(KuUtil.isResultSuccess(re)){
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
	public int sendAllNews(int groupId, String mediaId) {
		Result<KfMessage> rs = sendAllNews(groupId, mediaId, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	@Override
	public Result<KfMessage> sendPreviewText(String openid, String content, boolean r) {
		String re = Mikoto.api.mass.preview(openid, "text", content);
		if(KuUtil.isResultSuccess(re)){
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
	public int sendPreviewText(String openid, String content) {
		Result<KfMessage> rs = sendPreviewText(openid, content, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	@Override
	public Result<KfMessage> sendPreviewNews(String openid, String mediaId, boolean r) {
		String re = Mikoto.api.mass.preview(openid, "news", mediaId);
		if(KuUtil.isResultSuccess(re)){
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
	public int sendPreviewNews(String openid, String mediaId) {
		Result<KfMessage> rs = sendPreviewNews(openid, mediaId, true);
		if(rs.getErrcode()==0)
			return 1;
		return 0;
	}

	


}
