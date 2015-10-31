package com.s1025.kuroko.module.passive.req;

public class ReqEvent extends ReqBase{
	private String Event;

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	@Override
	public String toString() {
		return "ReqEvent [Event=" + Event + ", toString()=" + super.toString()
				+ "]";
	}

}
