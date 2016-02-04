package com.s1025.kuroko.ks;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.model.Action;
import com.s1025.kuroko.model.req.ReqBase;

public class ActionCenter {
	
	public boolean dispose(ReqBase reqBase, String reply){
		Action action = getAction(reply, Kuroko.ACTIONPATH);
		boolean b = false;
		
		try {
			Class<KurokoAction> cla = (Class<KurokoAction>) Class.forName(action.getClasspath());
			KurokoAction coj = cla.newInstance();
			coj.init();
			b = coj.service(reqBase, action);
			coj.dest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
	public Action getAction(String key, String path){
		Action action = new Action();
        SAXReader reader = new SAXReader();
        Document doc = null;
		try {
			doc = reader.read(path);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Element root = doc.getRootElement();
        
        @SuppressWarnings("unchecked")
        List<Element> actions = root.elements();
        for (Element a : actions) {
        	if("action".equals(a.getName())){
        		String content = a.element("content").getText();
        		if(content.equals(key)){
        			Map<String, String> map = new HashMap<String, String>();
        			String classpath = a.element("class").getText();
            		action.setContent(content);
            		action.setClasspath(classpath);
            		
            		
            		List<Element> params = a.elements("param");
        			
            		for(Element param:params){
            			map.put(param.element("name").getText(), param.element("value").getText());
            		}
            		
            		action.setParam(map);
            		
        		}
        	}
        }
        return action;
	}
	
	public Action searchAction(String key, String path){
		Action action = new Action();
        Document doc = getDoc(path);
		
        Element root = doc.getRootElement();
        
        @SuppressWarnings("unchecked")
        List<Element> actions = root.elements("action");
        for (Element a : actions) {
        	String content = a.element("content").getText();
        	if(key.equals(content)){
        		Map<String, String> map = new HashMap<String, String>();
        		String classpath = a.element("class").getText();
            	
        		action.setContent(content);
            	action.setClasspath(classpath);
            		
            	List<Element> params = a.elements("param");
        			
            	for(Element param:params){
            			map.put(param.element("name").getText(), param.element("value").getText());
            	}
            		
            	action.setParam(map);
            	
            	return action;
            		
        	}
        }
        
        
        List<Element> includes = root.elements("include");
        for(Element include:includes){
        	Action a = searchAction(key, include.getText());
        	if(a!=null){
        		return a;
        	}
        }
       
        
        return null;
	}
	
	public Document getDoc(String path){
		Document doc = null;
		SAXReader reader = new SAXReader();
		if(path.startsWith("package:")){
			path = path.substring(8);
			InputStream is = this.getClass().getResourceAsStream("/"+path);
			
			try {
				doc = reader.read(is);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				doc = reader.read(path);
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return doc;
	}
	
}
