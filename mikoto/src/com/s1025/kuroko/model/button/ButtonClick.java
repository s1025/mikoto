package com.s1025.kuroko.model.button;

public class ButtonClick extends Button{
	
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
		return "ButtonClick [type=" + type + ", key=" + key + "]";
	}
	public String toJson(){
		return "{\"type\":\""+type+"\","
				+ "\"name\":\""+this.getName()+"\","
				+ "\"key\":\""+key+"\"}";
	}

}
