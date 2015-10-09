package com.s1025.kuroko.util;

public class Util {
	public static boolean isResultSuccess(String json){
		int codeIndex = json.indexOf("errcode");
		int msgIndex = json.indexOf("errmsg");
		
		if(codeIndex!=-1){
			String errCode = json.substring(json.indexOf(codeIndex)+9, json.indexOf(msgIndex)-2);
			if(!"0".equals(errCode)){
				return false;
			}
		}
		return true;
	}
}
