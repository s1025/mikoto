package com.fkxpjj.mikoto.builder;

import java.util.ArrayList;
import java.util.List;

import com.fkxpjj.mikoto.model.button.ButtonBase;
import com.fkxpjj.mikoto.model.button.ButtonClick;
import com.fkxpjj.mikoto.model.button.ButtonMedia;
import com.fkxpjj.mikoto.model.button.ButtonScancodePush;
import com.fkxpjj.mikoto.model.button.ButtonScancodeWaitmsg;
import com.fkxpjj.mikoto.model.button.ButtonSub;
import com.fkxpjj.mikoto.model.button.ButtonType;
import com.fkxpjj.mikoto.model.button.ButtonView;

public class MenuBuilder {
	private List<ButtonBase> menu = new ArrayList<ButtonBase>();
	
	public List<ButtonBase> getMenu() {
		return menu;
	}

	public void setMenu(List<ButtonBase> menu) {
		this.menu = menu;
	}

	public void add(ButtonBase button){
		menu.add(button);
	}
	
	public void add(ButtonBase button, int index){
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
	}
	
	public void addClick(String name, String key, int index){
		ButtonClick button = new ButtonClick();
		button.setType(ButtonType.CLICK);
		button.setName(name);
		button.setKey(key);
		this.add(button, index);
	}
	
	public void addView(String name, String url, int index){
		ButtonView button = new ButtonView();
		button.setType(ButtonType.VIEW);
		button.setName(name);
		button.setUrl(url);
		this.add(button, index);
	}
	
	public void addSub(String name, int index){
		ButtonSub button = new ButtonSub();
		button.setName(name);
		this.add(button, index);
	}
	
	public void addMedia(String name, String mediaId, int index){
		ButtonMedia button = new ButtonMedia();
		button.setName(name);
		button.setType(ButtonType.MEDIAID);
		button.setMediaId(mediaId);
		this.add(button, index);
	}
	
	public void addScancodePush(String name, String key, int index){
		ButtonScancodePush button = new ButtonScancodePush();
		button.setName(name);
		button.setType(ButtonType.SCANCODEPUSH);
		button.setKey(key);
		this.add(button, index);
	}
	
	public void addScancodeWaitmsg(String name, String key, int index){
		ButtonScancodeWaitmsg button = new ButtonScancodeWaitmsg();
		button.setName(name);
		button.setType(ButtonType.SCANCODEWAITMSG);
		button.setKey(key);
		this.add(button, index);
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
