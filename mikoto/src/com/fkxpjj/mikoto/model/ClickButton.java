package com.fkxpjj.mikoto.model;

public class ClickButton extends BaseButton{
	
	private String type;
	private String key;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "ClickButton [type=" + type + ", key=" + key + "]";
	}
	
	

}
