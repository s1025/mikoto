package com.s1025.kuroko.dao;

import com.s1025.kuroko.model.Media;

public interface IMediaDAO {
	public int insert(Media media);
	public Media select(int mid);
	public int delete(int mid);
	public int update(Media media);
}
