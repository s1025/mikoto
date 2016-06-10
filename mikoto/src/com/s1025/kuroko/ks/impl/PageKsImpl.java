package com.s1025.kuroko.ks.impl;

import com.google.gson.Gson;
import com.s1025.kuroko.ks.PageKs;
import com.s1025.kuroko.model.ErrResult;
import com.s1025.kuroko.model.KuUtil;
import com.s1025.kuroko.model.PageAT;
import com.s1025.kuroko.model.Result;
import com.s1025.mikoto.Mikoto;

public class PageKsImpl implements PageKs{

	Gson gson = new Gson();
	
	@Override
	public Result<PageAT> getPageAT(String code) {
		String re = Mikoto.api.page.authorize(code);
		if(KuUtil.isResultSuccess(re)){
			PageAT pageAT = gson.fromJson(re, PageAT.class);
			Result<PageAT> rs = new Result<PageAT>(0, "ok", pageAT, null);
			return rs;
		} else {
			ErrResult er = gson.fromJson(re, ErrResult.class);
			Result<PageAT> rs = new Result<PageAT>(er);
			return rs;
		}
	}

}
