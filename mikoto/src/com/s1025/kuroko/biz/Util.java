package com.s1025.kuroko.biz;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Util {
	public static Map<String,String> fromJson(String json){
		return new Gson().fromJson(json,new TypeToken<Map<String, String>>() {}.getType());
	}
}
