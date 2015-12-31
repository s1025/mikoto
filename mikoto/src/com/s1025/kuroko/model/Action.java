package com.s1025.kuroko.model;

import java.util.Map;

public class Action {
	private String content;
	private String classpath;
	private Map<String,String> param;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getClasspath() {
		return classpath;
	}
	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}
	public Map<String, String> getParam() {
		return param;
	}
	public void setParam(Map<String, String> param) {
		this.param = param;
	}
	@Override
	public String toString() {
		return "Action [content=" + content + ", classpath=" + classpath + ", param=" + param + "]";
	}
	
	
}
