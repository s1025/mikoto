package com.s1025.kuroko.module;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class KuUtil {
	public static boolean isResultSuccess(String json){
		int codeIndex = json.indexOf("errcode");
		int msgIndex = json.indexOf("errmsg");
		if(codeIndex!=-1){
			String errCode = json.substring(codeIndex+9, msgIndex-2);
			if(!"0".equals(errCode)){
				return false;
			}
		}
		return true;
	}
	
	public static Map<String,String> fromJson(String json){
		return new Gson().fromJson(json,new TypeToken<Map<String, String>>() {}.getType());
	}
}
