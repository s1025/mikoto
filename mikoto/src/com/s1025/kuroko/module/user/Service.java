package com.s1025.kuroko.module.user;

import com.google.gson.Gson;
import com.s1025.kuroko.module.ErrResult;
import com.s1025.kuroko.module.KuUtil;
import com.s1025.kuroko.module.Result;
import com.s1025.mikoto.Mikoto;

public class Service {
	
	Gson gson = new Gson();
	
	public Result createGroup(String name){
		String re = Mikoto.api.group.createGroup(name);
		System.out.println(re);
		if(KuUtil.isResultSuccess(re)){
			return gson.fromJson(re, ResultGroup.class);
		}else{
			return gson.fromJson(re, ErrResult.class);
		}
	}
	
	public Result deleteGroup(int id){
		String re = Mikoto.api.group.deleteGroup(id);System.out.println(re);
		return gson.fromJson(re, ErrResult.class);
	}
}
