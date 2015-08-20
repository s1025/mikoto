package com.s1025.kuroko.result;

public class ThumbMediaResult extends ResultBase{
	private String type;
	private String thumb_media_id;
	private String created_at;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "ThumbMediaResult [type=" + type + ", thumb_media_id="
				+ thumb_media_id + ", created_at=" + created_at + "]";
	}
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
}
