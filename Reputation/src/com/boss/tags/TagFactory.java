package com.boss.tags;

import java.util.ArrayList;
import java.util.List;

import com.base.messages.ConfigData;
import com.base.utils.MessageUtils;

public class TagFactory extends ConfigData{

	public String item = "";
	public String name = "";
	public String target = "";
	public List<String> lore = new ArrayList<String>();
	
	public static TagFactory instance(String i) {
		TagFactory factory = new TagFactory(i);
		return factory;
	}
	
	public static TagFactory instance(List<String> i) {
		TagFactory factory = new TagFactory(i);
		return factory;
	}
	
	public TagFactory(String item) {
		this.item = item;
	}
	
	public TagFactory(List<String> lore) {
		this.lore = lore;
	}
	
	public String parse() {
		return this.parse(this.item);
	}
	
	public List<String> listParse(){
		
		List<String> builder = new ArrayList<String>();
		
		this.lore.forEach(i -> {
			
			builder.add(parse(i));
			
		});
		
		return builder;
	}
	
	private String parse(String parser) {
		
		parser = parser.replace("%prefix%", messages.PREFIX);
		parser = parser.replace("%version%", "1.0");
		parser = parser.replace("%user%", this.name);
		parser = parser.replace("%target%", this.target);

		
		return MessageUtils.translateAlternateColorCodes(parser);
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public TagFactory setName(String name) {
		this.name = name;
		return this;
	}

	public String getTarget() {
		return target;
	}

	public TagFactory setTarget(String target) {
		this.target = target;
		return this;
	}

	public List<String> getLore() {
		return lore;
	}

	public TagFactory setLore(List<String> lore) {
		this.lore = lore;
		return this;
	}

}
