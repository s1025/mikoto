package com.fkxpjj.mikoto.model;

import java.util.List;

/**
 * 关键词自动回复规则模型。
 * 
 * @author fkxpjj
 *
 */
public class ReplyRule {
	private String name;
	private boolean replayALL;
	private List<String> keys;
	private List<String> reply;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isReplayALL() {
		return replayALL;
	}
	public void setReplayALL(boolean replayALL) {
		this.replayALL = replayALL;
	}
	public List<String> getKeys() {
		return keys;
	}
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	public List<String> getReply() {
		return reply;
	}
	public void setReply(List<String> reply) {
		this.reply = reply;
	}
	
	
}
