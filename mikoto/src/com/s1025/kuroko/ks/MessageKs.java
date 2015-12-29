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
	public Result<Reply> matchRule(String key, boolean r);
	public Result<Rule> addRule(Rule rule, boolean r);
	public int addRule(Rule rule);
	public List<Reply> matchRule(String key);
	public Result<KfMessage> sendText(String to, String from, String content, boolean r);
	public int sendText(String to, String from, String content);
	public Result<KfMessage> sendImg(String to, String from, String mediaId, boolean r);
	public int sendImg(String to, String from, String mediaId);
}
