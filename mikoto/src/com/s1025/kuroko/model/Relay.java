package com.s1025.kuroko.model;

public class Relay {
	private String name;
	private String key;
	private String content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "RemoteThird [name=" + name + ", key=" + key + ", content=" + content + "]";
	}
}
