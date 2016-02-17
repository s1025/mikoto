package com.s1025.kuroko.model.req;

public class ReqEventScan extends ReqEvent{
	private long EventKey;
	private String Ticket;
	public long getEventKey() {
		return EventKey;
	}
	public void setEventKey(long eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	@Override
	public String toString() {
		return "ReqEventScan [EventKey=" + EventKey + ", Ticket=" + Ticket + ", toString()=" + super.toString() + "]";
	}
	public String getHexKey(){
		String skey = Long.toHexString(EventKey);
		for(int i = skey.length();i<8;i++){
			skey = "0"+skey;
		}
		return skey;
	}

	
	
}
