package com.fkxpjj.demo;

import com.s1025.mikoto.Mikoto;

public class MassTest {
	public static void main(String[] args){
		Mikoto.build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		String s = Mikoto.api.mass.sendallMedia("false", "0", "UFAuIan48n9bY_wbqR0kfn_j8Ch-9Oa-OerT3lQ84lQ", "mpnews");
		System.out.println(s);
	}
}
