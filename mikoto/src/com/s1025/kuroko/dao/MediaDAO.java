package com.s1025.kuroko.dao;

import com.s1025.kuroko.model.Media;

public interface MediaDAO {
	public int insert(Media media);
	public int delete(int mid);
	public Media select(int mid);
	public int update(Media media);
}
