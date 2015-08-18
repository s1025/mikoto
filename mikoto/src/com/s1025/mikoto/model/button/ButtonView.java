package com.s1025.mikoto.model.button;


public class ButtonView extends ButtonBase{
	
	private String type;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toJson(){
		return "{\"type\":\""+type+"\","
				+ "\"name\":\""+this.getName()+"\","
				+ "\"url\":\""+url+"\"}";
	}
}
