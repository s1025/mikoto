package com.fkxpjj.mikoto.model;

import java.util.ArrayList;
import java.util.List;

public class PopupButton extends BaseButton{
	private List<Button> sub_button = new ArrayList<Button>();
	
	public void add(Button button){
		sub_button.add(button);
	}

	public List<Button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<Button> sub_button) {
		this.sub_button = sub_button;
	}



}
