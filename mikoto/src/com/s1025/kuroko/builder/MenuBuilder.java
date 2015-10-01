package com.s1025.kuroko.builder;

import java.util.ArrayList;
import java.util.List;

import com.s1025.mikoto.model.button.ButtonBase;
import com.s1025.mikoto.model.button.ButtonClick;
import com.s1025.mikoto.model.button.ButtonMedia;
import com.s1025.mikoto.model.button.ButtonScancodePush;
import com.s1025.mikoto.model.button.ButtonScancodeWaitmsg;
import com.s1025.mikoto.model.button.ButtonSub;
import com.s1025.mikoto.model.button.ButtonType;
import com.s1025.mikoto.model.button.ButtonView;

public class MenuBuilder {
	private List<ButtonBase> menu = new ArrayList<ButtonBase>();
	
	public List<ButtonBase> getMenu() {
		return menu;
	}

	public void setMenu(List<ButtonBase> menu) {
		this.menu = menu;
	}

	public MenuBuilder add(ButtonBase button){
		menu.add(button);
		return this;
	}
	
	public MenuBuilder add(ButtonBase button, int index){
		if(index>=menu.size()) menu.add(button);
		else if(index<menu.size()){
			ButtonBase buttonBase = menu.get(index);
			if(buttonBase instanceof ButtonSub){
				ButtonSub sub = (ButtonSub) buttonBase;
				sub.add(button);
			} else {
				menu.remove(index);
				menu.add(index,button);
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
			ButtonBase button = menu.get(i);
			sub += button.toJson();
			if(i!=menu.size()-1){
				sub += ",";
			}
		}
		return "{\"button\":["+sub+"]}";
	}
}
