package com.fkxpjj.demo;

import org.dom4j.Document;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.ActionCenter;
import com.s1025.kuroko.ks.KurokoAction;
import com.s1025.kuroko.model.Action;

public class ActionTest {
	public static void main(String[] args){
		Init.init();
		ActionCenter ac = new ActionCenter();
		Action action = ac.searchAction("subscribe", "C:\\soft\\work\\CODE\\eclipseEE\\mikoto\\mikoto\\config\\actions.xml");
		System.out.println(action);
		
	}
	
}
