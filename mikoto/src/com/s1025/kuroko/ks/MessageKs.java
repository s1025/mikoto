package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Rule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.Reply;

public interface MessageKs {
	public boolean router(HttpServletRequest req, HttpServletResponse resp);
	
	//public Result<Reply> matchRule(String key, boolean r);
	//public List<Reply> matchRule(String key);
	
	public Result<Rule> addRule(Rule rule);
	public Result<Rule> delRule(String name);
	public Result<Rule> getRule();
	
	public Result<KfMessage> sendText(String to, String from, String content);	
	public Result<KfMessage> sendImg(String to, String from, String mediaId);	
	public Result<KfMessage> sendNews(String to, String from, String mediaId);
	
	public Result<KfMessage> sendAllText(int groupId, String content);
	public Result<KfMessage> sendAllNews(int groupId, String mediaId);
	public Result<KfMessage> sendPreviewText(String openid, String content);	
	public Result<KfMessage> sendPreviewNews(String openid, String mediaId);
	
}
