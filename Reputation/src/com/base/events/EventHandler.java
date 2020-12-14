package com.base.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.Plugin;

import com.base.main.Reputation;

public class EventHandler {

    public static List<SubEvent> events = new ArrayList<SubEvent>();
	
    private Plugin plugin = Reputation.instance;
    
	public void setup() {
		events.forEach(i -> plugin.getServer().getPluginManager().registerEvents(i, plugin));
	}
	
}
