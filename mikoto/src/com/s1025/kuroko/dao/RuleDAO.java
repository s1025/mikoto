package com.s1025.kuroko.dao;

import java.util.List;

import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.Reply;
import com.s1025.kuroko.model.Rule;

public interface RuleDAO {
	public int insert(Rule rule);
	public int delete(String name);
	public Rule select(String name);
	public List<Rule> selectAll();
	
	public Rule selectRuleOnly(String name);
	public List<Key> selectMatchKey(String type, String content);
	public List<Reply> selectReply(String rname);
}
