package com.fkxpjj.demo;


import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.model.News;
import com.s1025.kuroko.model.Result;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.model.App;

public class KfTest {
	public static void main (String[] args){
		//Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		//oVW-oszd62QE_kT66ilsRuuOJspA
		//String s =Mikoto.api.kf.sendCustomImage("oVW-oszd62QE_kT66ilsRuuOJspA", "UGNBhy32X--4JOvF5J2mytPmu8Jm9Ful9LRtsHCNJV0");
		//String s = Mikoto.api.kf.addKf("", name, password);
		//System.out.println(s);
		
		//MediaDAO mediaDAO = new MediaDAOimpl();
		
		//Media s = mediaDAO.select(4);
		
		Init.init();
		
		Result<KfMessage> r = Kuroko.ks.messageKs.sendNews("oVW-oszd62QE_kT66ilsRuuOJspA", "system", "eVnrau9ed1IjfY78zCnEStTokGsoYQ4zkliXzoGJzTY");
		//String r = Mikoto.api.kf.sendCustomNews("oVW-oszd62QE_kT66ilsRuuOJspA", "eVnrau9ed1IjfY78zCnEStTokGsoYQ4zkliXzoGJzTY");
		System.out.println(r.toString());;

	}

}
