package com.fkxpjj.demo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLTest {

	public static void main(String[] args) throws DocumentException {
	        Map<String, String> map = new HashMap<String, String>();
	        SAXReader reader = new SAXReader();
	        Document doc = reader.read("src/actions.xml");
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
	        System.out.println(map);
	}

}
