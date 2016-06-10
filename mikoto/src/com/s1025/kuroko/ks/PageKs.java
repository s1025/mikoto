package com.s1025.kuroko.ks;

import com.s1025.kuroko.model.PageAT;
import com.s1025.kuroko.model.Result;

public interface PageKs {
	public Result<PageAT> getPageAT(String code);

}
