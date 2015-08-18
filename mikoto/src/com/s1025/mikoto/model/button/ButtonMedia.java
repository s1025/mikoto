package com.s1025.mikoto.model.button;

public class ButtonMedia extends ButtonBase{
	private String type;
	private String mediaId;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	public String toJson(){
		return "{\"type\":\""+type+"\","
				+ "\"name\":\""+this.getName()+"\","
				+ "\"media_id\":\""+mediaId+"\"}";
	}
}
