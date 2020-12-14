package com.base.messages;

import org.bukkit.configuration.file.FileConfiguration;

import com.base.main.Reputation;

public class Permissions {

	public static final Permissions instance = new Permissions();
	
	public FileConfiguration permissions = Reputation.instance.configManager.getConfig("permissions").configuration;
	
	public final String DEFAULT = permissions.getString("Permissions.default");
	public final String ADMIN = permissions.getString("Permissions.admin");
	
	public Permissions() {
		
	}
	
	public static Permissions instance() {
		return instance;
	}
	
}
