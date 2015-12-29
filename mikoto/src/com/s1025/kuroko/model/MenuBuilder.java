package com.s1025.kuroko.model;

import java.util.ArrayList;
import java.util.List;

import com.s1025.kuroko.model.button.Button;
import com.s1025.kuroko.model.button.ButtonClick;
import com.s1025.kuroko.model.button.ButtonMedia;
import com.s1025.kuroko.model.button.ButtonScancodePush;
import com.s1025.kuroko.model.button.ButtonScancodeWaitmsg;
import com.s1025.kuroko.model.button.ButtonSub;
import com.s1025.kuroko.model.button.ButtonType;
import com.s1025.kuroko.model.button.ButtonView;



public class MenuBuilder {
	private List<Button> menu = new ArrayList<Button>();
	
	public List<Button> getMenu() {
		return menu;
	}

	public void setMenu(List<Button> menu) {
		this.menu = menu;
	}

	public MenuBuilder add(Button button){
		menu.add(button);
		return this;
	}
	
	public MenuBuilder add(Button button, int index){
		if(index>menu.size()) menu.add(button);
		else if(index<=menu.size()){
			Button buttonBase = menu.get(index-1);
			if(buttonBase instanceof ButtonSub){
				ButtonSub sub = (ButtonSub) buttonBase;
				sub.add(button);
			} else {
				menu.remove(index-1);
				menu.add(index-1,button);
			}
		}
		return this;
	}
	
	public MenuBuilder addClick(String name, String key, int index){
		ButtonClick button = new ButtonClick();
		button.setType(ButtonType.CLICK);
		button.setName(name);
		button.setKey(key);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addView(String name, String url, int index){
		ButtonView button = new ButtonView();
		button.setType(ButtonType.VIEW);
		button.setName(name);
		button.setUrl(url);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addSub(String name, int index){
		ButtonSub button = new ButtonSub();
		button.setName(name);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addMedia(String name, String mediaId, int index){
		ButtonMedia button = new ButtonMedia();
		button.setName(name);
		button.setType(ButtonType.MEDIAID);
		button.setMediaId(mediaId);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addScancodePush(String name, String key, int index){
		ButtonScancodePush button = new ButtonScancodePush();
		button.setName(name);
		button.setType(ButtonType.SCANCODEPUSH);
		button.setKey(key);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addScancodeWaitmsg(String name, String key, int index){
		ButtonScancodeWaitmsg button = new ButtonScancodeWaitmsg();
		button.setName(name);
		button.setType(ButtonType.SCANCODEWAITMSG);
		button.setKey(key);
		this.add(button, index);
		return this;
	}

	public String toJson(){
		String sub = "";
		for(int i =0; i<menu.size(); i++){
			Button button = menu.get(i);
			sub += button.toJson();
			if(i!=menu.size()-1){
				sub += ",";
			}
		}
		return "{\"button\":["+sub+"]}";
	}
}
