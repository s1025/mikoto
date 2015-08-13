package com.fkxpjj.mikoto.demo;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.api.KfApi;
import com.fkxpjj.mikoto.util.Builder;

public class KfTest {
	public static void main (String[] args){
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		//oVW-oszd62QE_kT66ilsRuuOJspA
		String s =Mikoto.api.kf.sendCustomImage("oVW-oszd62QE_kT66ilsRuuOJspA", "UGNBhy32X--4JOvF5J2mytPmu8Jm9Ful9LRtsHCNJV0");
		//String s = KfApi.getKfList();
		System.out.println(s);
	}

}
