
package com.base.commands;

import org.bukkit.entity.Player;

import com.base.main.Reputation;
import com.base.utils.MessageUtils;

public class Register extends SubCommand {

    @Override
    public void onCommand(Player player, String[] args) {
    	
        	MessageUtils.sendMessage(player, Reputation.getInstance().reputationController.registerPlayer(player, 0).getResponse());
    }

    @Override

    public String name() {
        return "register";
    }

    @Override
    public String info() {
        return "manually register yourself into the system.";
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