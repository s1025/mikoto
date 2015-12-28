package com.s1025.kuroko.model;

public class Media {
	private int mid;
	private String name;
	private String type;
	private int temp;
	private String media_id;
	private String url;
	private String created_at;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Media [mid=" + mid + ", name=" + name + ", type=" + type
				+ ", temp=" + temp + ", media_id=" + media_id + ", url=" + url
				+ ", created_at=" + created_at + "]";
	}
	
	
}
