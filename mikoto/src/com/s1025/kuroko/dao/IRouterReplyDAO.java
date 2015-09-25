package com.s1025.kuroko.dao;

import com.s1025.kuroko.plugin.router.Reply;

public interface IRouterReplyDAO {
	public int insert(Reply reply);
	public Reply select(String rname, String content);
	public int update(Reply reply);
	public int delete(String rname, String content);
}
