package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Media;

public interface MediaKs {
	public Result<Media> addImage(String name, String path, boolean r);
	public int addImage(String name, String path);
}
