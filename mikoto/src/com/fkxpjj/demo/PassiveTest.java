package com.fkxpjj.demo;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.RuleBuilder;
import com.s1025.mikoto.Mikoto;

public class PassiveTest {
	public static void main(String[] args){
		
		Init.init();
		
		RuleBuilder rb = new RuleBuilder("r2");
		
		rb.addKey("data");
		rb.addKey("default",true,"system");
		//rb.addKey("pm");
		
		rb.addReply("data","action");
		rb.addReply("aaa");
		//rb.addReply("ºÙºÙ");
		
		Kuroko.ks.messageKs.addRule(rb.getRule());
	}

}
