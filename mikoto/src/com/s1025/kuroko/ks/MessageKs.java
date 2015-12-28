package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Result;

import java.util.List;

import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.Reply;

public interface MessageKs {
	public Result<Reply> matchRule(String key, boolean r);
	public List<Reply> matchRule(String key);
	public Result<KfMessage> sendText(String to, String from, String content, boolean r);
	public int sendText(String to, String from, String content);
}
