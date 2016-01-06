package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Media;
import com.s1025.kuroko.model.MediaCount;

public interface MediaKs {
	public Result<Media> addImage(String name, String path, boolean r);
	public int addImage(String name, String path);
	
	//public Result<Media> addNews();
	
	public Result<MediaCount> getMediaCount(boolean r);
	public MediaCount getMediaCount();
}
