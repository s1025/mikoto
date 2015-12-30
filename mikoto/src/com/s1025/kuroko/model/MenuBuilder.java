package com.s1025.kuroko.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.s1025.kuroko.model.button.Button;
import com.s1025.kuroko.model.button.ButtonType;
import com.s1025.kuroko.model.button.Menu;



public class MenuBuilder {
	private List<Button> button = new ArrayList<Button>();
	private Map<String, String> rule = new HashMap<String, String>();
	
	public MenuBuilder add(Button button){
		this.button.add(button);
		return this;
	}
	
	public MenuBuilder add(Button button, int index){
		if(index>this.button.size()) this.button.add(button);
		else if(index<=this.button.size()){
			Button buttonBase = this.button.get(index-1);
			if(buttonBase.getType().equals(ButtonType.SUBBUTTON)){
				if(buttonBase.getSub_button()==null){
					buttonBase.setSub_button(new ArrayList<Button>());
				}
				buttonBase.getSub_button().add(button);
			} else {
				this.button.remove(index-1);
				this.button.add(index-1,button);
			}
		}
		return this;
	}
	
	public MenuBuilder addClick(String name, String key, int index){
		Button button = new Button();
		button.setType(ButtonType.CLICK);
		button.setName(name);
		button.setKey(key);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addView(String name, String url, int index){
		Button button = new Button();
		button.setType(ButtonType.VIEW);
		button.setName(name);
		button.setUrl(url);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addSub(String name, int index){
		Button button = new Button();
		button.setName(name);
		button.setType(ButtonType.SUBBUTTON);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addMedia(String name, String mediaId, int index){
		Button button = new Button();
		button.setName(name);
		button.setType(ButtonType.MEDIAID);
		button.setMedia_id(mediaId);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addScancodePush(String name, String key, int index){
		Button button = new Button();
		button.setName(name);
		button.setType(ButtonType.SCANCODEPUSH);
		button.setKey(key);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addScancodeWaitmsg(String name, String key, int index){
		Button button = new Button();
		button.setName(name);
		button.setType(ButtonType.SCANCODEWAITMSG);
		button.setKey(key);
		this.add(button, index);
		return this;
	}
	
	public MenuBuilder addMediaId(String name, String mediaId, int index){
		Button button = new Button();
		button.setName(name);
		button.setMedia_id(mediaId);
		button.setType(ButtonType.MEDIAID);
		this.add(button,index);
		return this;
	}
	
	public MenuBuilder addViewLimited(String name, String mediaId, int index){
		Button button = new Button();
		button.setName(name);
		button.setMedia_id(mediaId);
		button.setType(ButtonType.VIEWLIMITED);
		this.add(button,index);
		return this;
	}
	
	public void addGroupRule(String groupId){
		rule.put("group_id", groupId);
	}
	public void addSexRule(String sex){
		rule.put("sex", sex);
	}
	public void addClientRule(String client){
		rule.put("client_platform_type", client);
	}
	public void addAddress(String country, String province, String city){
		rule.put("country", country);
		rule.put("province", province);
		rule.put("city", city);
	}
	
	public Menu getMenu(){
		Menu menu = new Menu();
		menu.setButton(button);
		if(rule.size()>0)
			menu.setMatchrule(rule);
		return menu;
	}
	
	
}
