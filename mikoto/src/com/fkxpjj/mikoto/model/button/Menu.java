package com.fkxpjj.mikoto.model.button;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Button> button = new ArrayList<Button>();

	public Menu(){}
	
	public void add(Button button){
		this.button.add(button);
	}
	
	public void add(Button button,int index){
		if (button instanceof PopupButton){
			this.button.set(index, button);
		}
	}

	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}
	
	
}
