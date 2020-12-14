package com.base.commands;

import org.bukkit.entity.Player;

import com.base.messages.ConfigData;

public abstract class SubCommand extends ConfigData {
	
    public SubCommand() {

    }

    public abstract void onCommand(Player player, String[] args);

    public abstract String name();
   
    public abstract String permission();

    public abstract String info();

    public abstract String[] aliases();

}
