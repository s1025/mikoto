package com.s1025.kuroko.ks;

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

import com.s1025.kuroko.model.Event;
import com.s1025.kuroko.model.MsgType;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.resp.RespBase;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class Parse {
	
	ReqBuilder reqBuilder = new ReqBuilder();
	
	public ReqBase getReq(HttpServletRequest req){
		Map<String, String> map = new HashMap<String, String>();
		ReqBase reqBase = new ReqBase();
		try {
			map = parseXML(req);
			String type = map.get("MsgType");
			if (MsgType.TEXT.equals(type)){
				reqBase = reqBuilder.XMLtoText(map);
			}/* else if(MsgType.IMAGE.equals(type)){
				reqBase = reqBuilder.XMLtoImg(map);
			}else if(MsgType.VOICE.equals(type)){
				reqBase = reqBuilder.XMLtoVoice(map);
			}else if(MsgType.VIDEO.equals(type)){
				reqBase = reqBuilder.XMLtoVideo(map);
			}else if(MsgType.SHORTVIDEO.equals(type)){
				reqBase = reqBuilder.XMLtoShortVideo(map);
			}else if(MsgType.LOCATION.equals(type)){
				reqBase = reqBuilder.XMLtoLocation(map);
			}else if(MsgType.LINK.equals(type)){
				reqBase = reqBuilder.XMLtoLink(map);
			}*/else if(MsgType.EVENT.equals(type)){
				String event = map.get("Event");
				if(Event.CLICK.equals(event)){
					reqBase = reqBuilder.XMLtoEventClick(map);
				} else if(Event.SCAN.equals(event)){
					reqBase = reqBuilder.XMLtoEventScan(map);
				} else if(Event.SUBSCRIBE.equals(event)){
					reqBase = reqBuilder.XMLtoSubscribe(map);
				} else if(Event.UNSUBSCRIBE.equals(event)){
					reqBase = reqBuilder.XMLtoUnSubscribe(map);
				} else reqBase.setMsgType(MsgType.NONE);
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
