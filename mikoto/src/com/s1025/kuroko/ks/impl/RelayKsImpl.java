package com.s1025.kuroko.ks.impl;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.ks.RelayKs;
import com.s1025.kuroko.ks.RuleBuilder;
import com.s1025.kuroko.model.Key;
import com.s1025.kuroko.model.Relay;
import com.s1025.kuroko.model.Result;
import com.s1025.kuroko.model.Rule;

public class RelayKsImpl implements RelayKs{

	@Override
	public Result<Relay> addRelay(Relay relay) {
		RuleBuilder rb = new RuleBuilder();
		String[] keys = relay.getKey().split(" ");
		for(String key:keys){
			rb.addKey(key, true, "text");
		}
		rb.setName("sys:relay:"+relay.getName());
		rb.addReply(relay.getContent(), "relay");
		Result<Rule> rs = Kuroko.ks.messageKs.addRule(rb.getRule());
		return new Result<Relay>(rs);
	}

	@Override
	public Result<Relay> delRelay(String name) {
		Result<Rule> rs = Kuroko.ks.messageKs.delRule(name);
		return new Result<Relay>(rs);
	}

	@Override
	public Result<Relay> getRelay() {
		Result<Rule> rs = Kuroko.ks.messageKs.getRule();
		List<Relay> relays = new ArrayList<Relay>();
		for(Rule rule:rs.getDatas()){
			Relay relay = new Relay();
			relay.setName(rule.getName());
			relay.setContent(rule.getReplys().get(0).getContent());
			String k = "";
			for(Key key:rule.getKeys()){
				k += key.getContent()+" ";
			}
			relay.setKey(k.substring(0,k.length()-1));
			relays.add(relay);
		}
		return new Result<Relay>(0,"ok",null,relays);
	}

}
