package com.fkxpjj.mikoto.demo;

import java.util.ArrayList;
import java.util.List;

import com.fkxpjj.mikoto.Mikoto;
import com.fkxpjj.mikoto.api.KfApi;
import com.fkxpjj.mikoto.model.active.ArticleKf;
import com.fkxpjj.mikoto.util.Builder;
import com.google.gson.Gson;

public class KfTest {
	public static void main (String[] args){
		new Builder().build("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		//oVW-oszd62QE_kT66ilsRuuOJspA
		//String s =Mikoto.api.kf.sendCustomImage("oVW-oszd62QE_kT66ilsRuuOJspA", "UGNBhy32X--4JOvF5J2mytPmu8Jm9Ful9LRtsHCNJV0");
		//String s = Mikoto.api.kf.addKf("", name, password);
		//System.out.println(s);
		
		String s = Mikoto.api.kf.sendCustomMusic("oVW-oszd62QE_kT66ilsRuuOJspA", "ttt", "ddd", "http://mikoto.fkxpjj.com/mikototest/music/cxjd.mp3", "http://mikoto.fkxpjj.com/mikototest/music/cxjd.mp3", "11");
		//String s = Mikoto.api.kf.sendCustomImage("oVW-oszd62QE_kT66ilsRuuOJspA", "H9aR8TJsPEnsKDB7vuR7tANXBW2g7V35mm8QY_OuN4i69Ug8HIks3HEDGM7X1yFw");
		System.out.println(s);
	}

}
