package com.fkxpjj.demo;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.module.passive.req.ReqText;
import com.s1025.kuroko.module.passive.resp.RespArticle;
import com.s1025.kuroko.module.passive.resp.RespNews;
import com.s1025.kuroko.module.router.Key;
import com.s1025.kuroko.module.router.Reply;
import com.s1025.kuroko.module.router.Rule;
import com.s1025.kuroko.module.router.RuleDAO;
import com.s1025.kuroko.module.router.RuleDAOimpl;
import com.s1025.mikoto.Mikoto;

public class PassiveTest {
	public static void main(String[] args){
		
		RuleDAOimpl ruleDAO = new RuleDAOimpl();
		
		Rule rule = new Rule();
		List<Rule> rules = new ArrayList<Rule>();
		List<Key> keys = new ArrayList<Key>();
		List<Reply> replys = new ArrayList<Reply>();
		
		rule.setName("t1");
		rule.setPri(5);
		rule.setRespAll(false);
		
		for(int i = 0; i<3; i++){
			Key key = new Key();
			key.setRname(rule.getName());
			key.setContent("tk"+i);
			key.setTotally(true);
			keys.add(key);
		}
		
		for(int j = 0; j<4; j++){
			Reply reply = new Reply();
			reply.setRname(rule.getName());
			reply.setType("text");
			reply.setContent("haha"+j);
			replys.add(reply);
		}
		
		rule.setKeys(keys);
		rule.setReplys(replys);

		rules = ruleDAO.selectAll();
		System.out.println(rules);
	}

}
