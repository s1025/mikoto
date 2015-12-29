package com.s1025.kuroko.model.button;

import java.util.ArrayList;
import java.util.List;

public class ButtonSub extends Button{
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

	public String toJson(){
		String sub = "";
		for(int i =0; i<sub_button.size(); i++){
			Button button = sub_button.get(i);
			sub += button.toJson();
			if(i!=sub_button.size()-1){
				sub += ",";
			}
		}
		return "{\"name\":\""+this.getName()+"\","
				+ "\"sub_button\":["+sub+"]}";
	}

}
