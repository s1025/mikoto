package com.fkxpjj.demo;

import java.util.Map;

import com.s1025.kuroko.module.KuUtil;
import com.s1025.mikoto.Mikoto;

public class Test {
	public static void main(String[] args){
		Mikoto.build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String json ="{'a':1,'b':2}";
		Map<String, String> map = KuUtil.fromJson(json);
		String a = map.get("a");
		String b = map.get("b");
		String c = map.get("c");
		System.out.println(a+" "+b+" "+c);
		if(c==null) System.out.println("ha");
	}
}
