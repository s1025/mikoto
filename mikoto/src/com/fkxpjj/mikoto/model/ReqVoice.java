package com.fkxpjj.mikoto.model;

public class ReqVoice extends ReqBase{
	private String mediaId;
	private String format;
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

}
