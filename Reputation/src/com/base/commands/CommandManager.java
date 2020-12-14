package com.base.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.base.main.Reputation;
import com.base.messages.ConfigData;
import com.base.utils.MessageUtils;

public class CommandManager extends ConfigData implements CommandExecutor {

    private static ArrayList<SubCommand> commands = new ArrayList<SubCommand>();

    private Reputation plugin;

    //Sub Commands
    public String main = "rep";
    public String help = "help";

    
    public void setup(Reputation plugin) {
    	this.setPlugin(plugin);
    	plugin.getCommand(main).setExecutor(this);
        CommandManager.commands.add(new Help());
        CommandManager.commands.add(new Register());
    }


    public static ArrayList<SubCommand> getCommands(){
    	return commands;
    }

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {


        if (!(sender instanceof Player)) {

            sender.sendMessage(messages.INAVLID_ENTITY);

            return true;

        }

        Player player = (Player) sender;
        
    	try {

        if (command.getName().equalsIgnoreCase(main)) {

            if (args.length == 0) {
            	MessageUtils.sendHelp(player);
                return true;

            }

            SubCommand target = this.get(args[0]);

            if (target == null) {

                player.sendMessage(messages.INVALID_SYNTEX);

                return true;

            }
            
		    if(!player.hasPermission(target.permission())) {
		    		MessageUtils.sendMessage(player, messages.INAVLID_PERMISSION);
		    		return true;
		    }

            ArrayList<String> arrayList = new ArrayList<String>();

            arrayList.addAll(Arrays.asList(args));

            arrayList.remove(0);
            
            try{
                target.onCommand(player,args);
            }catch (Exception e){
                player.sendMessage(messages.ERROR);
                e.printStackTrace();
            }

        }


    }catch(Throwable e) {
        player.sendMessage(messages.ERROR);
        e.printStackTrace();
    }

        return true;
    
    }



    private SubCommand get(String name) {

        Iterator<SubCommand> subcommands = CommandManager.commands.iterator();



        while (subcommands.hasNext()) {

            SubCommand sc = (SubCommand) subcommands.next();



            if (sc.name().equalsIgnoreCase(name)) {

                return sc;

            }



            String[] aliases;

            int length = (aliases = sc.aliases()).length;



            for (int var5 = 0; var5 < length; ++var5) {

                String alias = aliases[var5];

                if (name.equalsIgnoreCase(alias)) {

                    return sc;

                }

            }

        }

        return null;

    }


	public Reputation getPlugin() {
		return plugin;
	}


	public void setPlugin(Reputation plugin) {
		this.plugin = plugin;
	}

}