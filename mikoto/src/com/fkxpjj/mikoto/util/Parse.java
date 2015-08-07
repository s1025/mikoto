package com.fkxpjj.mikoto.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.fkxpjj.mikoto.model.ReqText;
import com.fkxpjj.mikoto.model.RespBase;
import com.fkxpjj.mikoto.model.RespText;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class Parse {
	public static Map<String, String> parseXML(HttpServletRequest req) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		
		InputStream inputStream = req.getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		
		for(Element e : elementList)
			map.put(e.getName(), e.getText());
		
		inputStream.close();
		inputStream = null;
		
		return map;
	}
	
	public static ReqText XMLtoText( Map<String, String> map){
		ReqText text = new ReqText();
		text.setFromUserName(map.get("FromUserName"));
		text.setToUserName(map.get("ToUserName"));
		text.setMsgType(map.get("MsgType"));
		text.setMsgId(map.get("MsgId"));
		text.setCreateTime("CreateTime");
		text.setContent("Content");
		return text;
	}
	
	public static String RespTextToXML(RespText respText){
		xstream.alias("xml", respText.getClass());  
	    return xstream.toXML(respText);  
	}
	
	public static String RespToXML(RespBase resp){
		xstream.alias("xml", resp.getClass());  
	    return xstream.toXML(resp);  
	}
	
	private static XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // 对所有xml节点的转换都增加CDATA标记  
	            boolean cdata = true;  
	  
	            @SuppressWarnings("unchecked")  
	            public void startNode(String name, Class clazz) {  
	                super.startNode(name, clazz);  
	            }  
	  
	            protected void writeText(QuickWriter writer, String text) {  
	                if (cdata) {  
	                    writer.write("<![CDATA[");  
	                    writer.write(text);  
	                    writer.write("]]>");  
	                } else {  
	                    writer.write(text);  
	                }  
	            }  
	        };  
	    }  
	});  

}
