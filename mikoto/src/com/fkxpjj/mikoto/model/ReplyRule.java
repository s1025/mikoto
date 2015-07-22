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
}
