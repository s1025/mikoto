package com.fkxpjj.demo;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.RuleBuilder;
import com.s1025.mikoto.Mikoto;

public class PassiveTest {
	public static void main(String[] args){
		
		Init.init();
		
		RuleBuilder rb = new RuleBuilder("tp");
		
		rb.addKey("pl");
		rb.addKey("pm");
		
		rb.addReply("込込込");
		rb.addReply("細細");
		
		Kuroko.ks.messageKs.addRule(rb.getRule());
	}

}
