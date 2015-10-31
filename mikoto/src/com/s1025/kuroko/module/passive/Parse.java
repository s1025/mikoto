package com.s1025.kuroko.module.passive;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.s1025.kuroko.Kuroko;
import com.s1025.kuroko.module.passive.req.ReqBase;
import com.s1025.kuroko.module.passive.resp.RespBase;
import com.s1025.mikoto.Mikoto;
import com.s1025.mikoto.model.Event;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class Parse {
	
	public ReqBase getReq(HttpServletRequest req){
		Map<String, String> map = new HashMap<String, String>();
		ReqBase reqBase = new ReqBase();
		try {
			map = parseXML(req);
			System.out.println(map.get("MsgType"));
			String type = map.get("MsgType");
			if (MsgType.TEXT.equals(type)){
				reqBase = Kuroko.builder.req.XMLtoText(map);
			} else if(MsgType.IMAGE.equals(type)){
				reqBase = Kuroko.builder.req.XMLtoImg(map);
			}else if(MsgType.VOICE.equals(type)){
				reqBase = Kuroko.builder.req.XMLtoVoice(map);
			}else if(MsgType.VIDEO.equals(type)){
				reqBase = Kuroko.builder.req.XMLtoVideo(map);
			}else if(MsgType.SHORTVIDEO.equals(type)){
				reqBase = Kuroko.builder.req.XMLtoShortVideo(map);
			}else if(MsgType.LOCATION.equals(type)){
				reqBase = Kuroko.builder.req.XMLtoLocation(map);
			}else if(MsgType.LINK.equals(type)){
				reqBase = Kuroko.builder.req.XMLtoLink(map);
			}else if(MsgType.EVENT.equals(type)){
				String event = map.get("Event");
				if(Event.SUBSCRIBE.endsWith(event)){
					reqBase = Kuroko.builder.req.XMLtoSubscribe(map);
				}
			} else reqBase.setMsgType(MsgType.NONE);
		} catch (Exception e) {
			e.printStackTrace();
			reqBase.setMsgType(MsgType.NONE);
		}
		
		return reqBase;
	}
	
	public Map<String, String> parseXML(HttpServletRequest req) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		req.setCharacterEncoding("UTF-8");
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
	
	public String RespToXML(RespBase resp){
		xstream.alias("xml", resp.getClass());  
	    String xml = xstream.toXML(resp);
	    xml = xml.replaceAll("com.fkxpjj.mikoto.model.resp.RespArticle", "item");
	    return xml;
	}
	
	private XStream xstream = new XStream(new XppDriver() {  
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
