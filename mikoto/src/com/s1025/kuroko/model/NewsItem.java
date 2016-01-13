package com.s1025.kuroko.model;

import java.util.List;

public class NewsItem {
	private String media_id;
	private NewsContent content;
	private String update_time;
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public NewsContent getContent() {
		return content;
	}
	public void setContent(NewsContent content) {
		this.content = content;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "NewsItem [media_id=" + media_id + ", content=" + content + ", update_time=" + update_time + "]";
	}
	
	
}
