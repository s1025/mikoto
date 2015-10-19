package com.s1025.kuroko.module.user;

public interface GroupDAO {
	public int insert(Group group);
	public int delete(int id);
	public Group select(int id);
	public int update(Group group);
	public int updateName(int id, String name);
	public int clean();
}
