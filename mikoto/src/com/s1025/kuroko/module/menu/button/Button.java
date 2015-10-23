package com.s1025.kuroko.module.menu.button;

public abstract class Button{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ButtonBase [name=" + name + "]";
	}
	
	public abstract String toJson();
}
