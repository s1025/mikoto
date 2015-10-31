package com.s1025.kuroko.module.router;

import java.util.List;

public interface RuleDAO {
	public int insert(Rule rule);
	public int delete(String name);
	public Rule select(String name);
	public List<Rule> selectAll();
}
