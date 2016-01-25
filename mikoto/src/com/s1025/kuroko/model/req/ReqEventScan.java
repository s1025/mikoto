package com.s1025.kuroko.model.req;

public class ReqEventScan extends ReqEvent{
	private int EventKey;
	private String Ticket;
	public int getEventKey() {
		return EventKey;
	}
	public void setEventKey(int eventKey) {
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
		return "ReqEventScan [EventKey=" + EventKey + ", Ticket=" + Ticket + "]";
	}
	
	
}
