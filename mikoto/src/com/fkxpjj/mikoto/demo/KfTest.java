package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.api.KfApi;
import com.fkxpjj.mikoto.util.Builder;

public class KfTest {
	public static void main (String[] args){
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		
		String s =KfApi.addKf("f445334303@gh_4fabcd229559", "fk", "96e79218965eb72c92a549dd5a330112");
		//String s = KfApi.getKfList();
		System.out.println(s);
	}

}
