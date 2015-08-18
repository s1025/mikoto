package com.s1025.mikoto.model.button;

public class ButtonBase{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toJson(){
		return "json";
	}

	@Override
	public String toString() {
		return "ButtonBase [name=" + name + "]";
	}
}
