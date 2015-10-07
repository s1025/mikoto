package com.s1025.kuroko.plugin.menu.model;

import java.util.ArrayList;
import java.util.List;

public class ButtonSub extends ButtonBase{
	private List<ButtonBase> sub_button = new ArrayList<ButtonBase>();

	public void add(ButtonBase button){
		sub_button.add(button);
	}
	
	public List<ButtonBase> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<ButtonBase> sub_button) {
		this.sub_button = sub_button;
	}

	public String toJson(){
		String sub = "";
		for(int i =0; i<sub_button.size(); i++){
			ButtonBase button = sub_button.get(i);
			sub += button.toJson();
			if(i!=sub_button.size()-1){
				sub += ",";
			}
		}
		return "{\"name\":\""+this.getName()+"\","
				+ "\"sub_button\":["+sub+"]}";
	}

}
