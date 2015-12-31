package com.fkxpjj.demo;


import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.model.KfMessage;
import com.s1025.kuroko.module.media.Media;
import com.s1025.kuroko.module.media.MediaDAO;
import com.s1025.kuroko.module.media.MediaDAOimpl;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.api.KfApi;
import com.s1025.mikoto.model.App;
import com.s1025.mikoto.model.active.ArticleKf;

public class KfTest {
	public static void main (String[] args){
		Mikoto.app = new App("wx591b08daf676e085", "921057ddd269c0ec8481430db96cc1bc");
		//oVW-oszd62QE_kT66ilsRuuOJspA
		//String s =Mikoto.api.kf.sendCustomImage("oVW-oszd62QE_kT66ilsRuuOJspA", "UGNBhy32X--4JOvF5J2mytPmu8Jm9Ful9LRtsHCNJV0");
		//String s = Mikoto.api.kf.addKf("", name, password);
		//System.out.println(s);
		
		//MediaDAO mediaDAO = new MediaDAOimpl();
		
		//Media s = mediaDAO.select(4);
		

	}

}
