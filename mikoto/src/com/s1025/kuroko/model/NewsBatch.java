package com.s1025.kuroko.model;

import java.util.List;

public class NewsBatch {
	private int total_count;
	private int item_count;
	private List<NewsItem> item;
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	public List<NewsItem> getItem() {
		return item;
	}
	public void setItem(List<NewsItem> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "NewsBatch [total_count=" + total_count + ", item_count=" + item_count + ", item=" + item + "]";
	}
	
	

}
