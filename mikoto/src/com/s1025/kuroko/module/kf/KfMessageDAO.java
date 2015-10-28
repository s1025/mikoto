package com.s1025.kuroko.module.kf;

public interface KfMessageDAO {
	public int insert(KfMessage message);
	public int delete(int kmid);
	public KfMessage select(int kmid);
	public int update(KfMessage message);
}
