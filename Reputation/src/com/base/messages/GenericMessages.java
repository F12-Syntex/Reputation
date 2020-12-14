package com.base.messages;

import org.bukkit.configuration.file.FileConfiguration;

import com.base.main.Reputation;
import com.base.utils.MessageUtils;

public class GenericMessages {

	public static final GenericMessages instance = new GenericMessages();
	
	public FileConfiguration messages = Reputation.getInstance().configManager.getConfig("messages").configuration;

	public final String space = "\n" + "\n";
	
	public final String PREFIX = MessageUtils.translateAlternateColorCodes(messages.getString("Messages.PREFIX"));
	public final String INVALID_SYNTEX = MessageUtils.translateAlternateColorCodes(messages.getString("Messages.INVALID_SYNTEX")).replace("%PREFIX%", PREFIX);
	public final String ERROR = MessageUtils.translateAlternateColorCodes(messages.getString("Messages.ERROR")).replace("%PREFIX%", PREFIX);
	public final String INAVLID_ENTITY = MessageUtils.translateAlternateColorCodes(messages.getString("Messages.INAVLID_ENTITY")).replace("%PREFIX%", PREFIX);
	public final String INAVLID_PERMISSION = MessageUtils.translateAlternateColorCodes(messages.getString("Messages.INAVLID_PERMISSION")).replace("%PREFIX%", PREFIX);

	public GenericMessages() {
		
	}

	public static GenericMessages instance() {
		return instance;
	}
	
}
