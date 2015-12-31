package com.fkxpjj.demo;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.model.Action;

public class ActionTest {
	public static void main(String[] args){
		Init.init();
		Kuroko.ACTIONPATH = System.getProperty("user.dir")+"/src/actions.xml";
		//Action action = KurokoAction.getMapFromXML("a");
		//System.out.println(action);
	}
	
}
