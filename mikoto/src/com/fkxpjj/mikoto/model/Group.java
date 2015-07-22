package com.fkxpjj.mikoto.model;
/**
 * 微信用户分组。
 * http://mp.weixin.qq.com/wiki/0/56d992c605a97245eb7e617854b169fc.html
 * @author fkxpjj
 *
 */
public class Group {
	private int id;
	private String name;
	private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "WXGroup [id=" + id + ", name=" + name + ", count=" + count
				+ "]";
	}
	
}
