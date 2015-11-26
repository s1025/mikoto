package com.s1025.kuroko.module.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.s1025.kuroko.module.passive.req.ReqBase;
import com.s1025.kuroko.module.passive.req.ReqText;

public class Action {
	public static final Map<String,IAction> actions = new HashMap<String,IAction>();
	
	public void dispose(ReqBase reqBase, String content, HttpServletResponse resp){
		IAction action = actions.get(content);
		if(action != null){
			action.service((ReqText)reqBase, resp);
		}
	}
	
	public void init(String path){
		 Map<String, String> map = getMapFromXML(path);
		 for (String key:map.keySet()){
			 String classname = map.get(key);
			 try {
				Class<IAction> caction= (Class<IAction>) Class.forName(classname);
				actions.put(key, caction.newInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	}
	
	public Map<String, String> getMapFromXML(String path){
        Map<String, String> map = new HashMap<String, String>();
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
        List<Element> list = root.elements();
        for (Element e : list) {
        	if("action".equals(e.getName())){
        		String content = e.element("content").getText();
        		String classPath = e.element("class").getText();
        		map.put(content, classPath);
        	}
        }
        return map;
}
	
}
