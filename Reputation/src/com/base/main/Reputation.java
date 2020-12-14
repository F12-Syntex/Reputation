package com.base.main;
import java.io.File;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.base.config.ConfigManager;
import com.base.events.EventHandler;
import com.base.profile.ReputationController;


public class Reputation extends JavaPlugin implements Listener{


    public static Reputation instance;
    public com.base.commands.CommandManager CommandManager;
    public ConfigManager configManager;
    public EventHandler eventHandler;
    public ReputationController reputationController;
	public static File ParentFolder;
	
	@Override
	public void onEnable(){
		
		ParentFolder = getDataFolder();
	    instance = this;
		
	    
	    configManager = new ConfigManager();
	    configManager.setup(this);
	    configManager.save();
	    
	    this.CommandManager = new com.base.commands.CommandManager();
	    this.CommandManager.setup(this);
	    
	    eventHandler = new com.base.events.EventHandler();
	    eventHandler.setup();
	    
	    this.reputationController = new ReputationController();
	    
	}
	
	@Override
	public void onDisable(){
		this.reputationController.save();
	}


	public static Reputation getInstance() {
		return instance;
	}
		
	
}
