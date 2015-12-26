package com.s1025.kuroko.dao;

import java.util.List;

import com.s1025.kuroko.model.Group;

public interface GroupDAO {
	public int insert(Group group);
	public int delete(int id);
	public Group select(int id);
	public List<Group> select();
	public int update(Group group);
	public int updateName(int id, String name);
	public int clean();
}
