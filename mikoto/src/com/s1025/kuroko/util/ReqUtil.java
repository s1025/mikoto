package com.s1025.kuroko.util;

import com.s1025.kuroko.model.Event;
import com.s1025.kuroko.model.MsgType;
import com.s1025.kuroko.model.req.ReqBase;
import com.s1025.kuroko.model.req.ReqEvent;

public class ReqUtil {
	
	public static String getType(ReqBase reqBase){
		String type = MsgType.NONE;	
		
		if(reqBase.getMsgType().equals(MsgType.TEXT)){
			type = MsgType.TEXT;
		}else if(reqBase.getMsgType().equals(MsgType.EVENT)){
			ReqEvent reqEvent = (ReqEvent) reqBase;
			if(Event.CLICK.equals(reqEvent.getEvent())){
				type = Event.CLICK;
			} else if(Event.SCAN.equals(reqEvent.getEvent())){
				type = Event.SCAN;
			} else if(Event.SUBSCRIBE.equals(reqEvent.getEvent())){
				type = Event.SUBSCRIBE;
			} else if(Event.UNSUBSCRIBE.equals(reqEvent.getEvent())){
				type = Event.UNSUBSCRIBE;
			}
		} 
		
		return type;
	}
}
