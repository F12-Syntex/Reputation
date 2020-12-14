
package com.base.commands;

import org.bukkit.entity.Player;

import com.base.main.Reputation;
import com.base.utils.MessageUtils;

public class Help extends SubCommand {

	private Reputation plugin = Reputation.getInstance();

    @Override
    public void onCommand(Player player, String[] args) {
    	MessageUtils.sendHelp(player);
    }

    @Override

    public String name() {
        return plugin.CommandManager.help;
    }

    @Override
    public String info() {
        return "displays the help command";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

	@Override
	public String permission() {
		return permissions.DEFAULT;	
	}
	

}