package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.req.ReqBase;

public interface KurokoAction {
	public void init();
	
	public void dest();
	
	public abstract boolean service(ReqBase reqBase);
	
	
	
}
