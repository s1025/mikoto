package com.s1025.kuroko.model.result;

public class MaterialResult extends ResultBase{
	private String media_id;
	private String url;
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
	@Override
	public String toString() {
		return "MaterialResult [media_id=" + media_id + ", url=" + url
				+ ", toString()=" + super.toString() + "]";
	}
}
