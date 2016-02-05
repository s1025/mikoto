package com.fkxpjj.demo;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.RuleBuilder;
import com.s1025.mikoto.Mikoto;

public class PassiveTest {
	public static void main(String[] args){
		
		Init.init();
		
		RuleBuilder rb = new RuleBuilder("system::unsubscribe");
		
		rb.addKey("system::unsubscribe");
		//rb.addKey("pm");
		
		rb.addReply("action","unsubscribe");
		//rb.addReply("ºÙºÙ");
		
		Kuroko.ks.messageKs.addRule(rb.getRule());
	}

}
