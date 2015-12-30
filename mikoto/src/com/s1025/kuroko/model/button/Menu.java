package com.s1025.kuroko.model.button;

import java.util.List;
import java.util.Map;

public class Menu {
	private List<Button> button;
	private Map<String,String> matchrule;

	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}

	public Map<String,String> getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(Map<String,String> matchrule) {
		this.matchrule = matchrule;
	}
}
