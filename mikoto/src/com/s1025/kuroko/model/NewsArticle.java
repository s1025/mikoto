package com.s1025.kuroko.model;

public class NewsArticle {
	private String title;       //必填，小于64个字
	private String thumb_media_id;
	private String content;
	private String content_source_url;
	private String digest;   //选填，单图文，默认抓取正文前54个字
	private String author;
	private int show_cover_pic;
	private String media_id;
	private int num;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent_source_url() {
		return content_source_url;
	}
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	public int getShow_cover_pic() {
		return show_cover_pic;
	}
	public void setShow_cover_pic(int show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "NewsArticle [title=" + title + ", thumb_media_id=" + thumb_media_id + ", content=" + content
				+ ", content_source_url=" + content_source_url + ", digest=" + digest + ", author=" + author
				+ ", show_cover_pic=" + show_cover_pic + ", media_id=" + media_id + ", num=" + num + "]";
	}
}
