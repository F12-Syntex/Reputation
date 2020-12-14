package com.base.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.base.main.Reputation;
import com.base.utils.Response;

public class ReputationController {

	private FileConfiguration configuration;
	private List<UserProfile> userMeta = new ArrayList<UserProfile>();
	
	public ReputationController() {
		
		this.configuration = Reputation.getInstance().configManager.getConfig("usermeta").configuration;
		
		ConfigurationSection userMeta = configuration.getConfigurationSection("Usermeta");
	
		for(String uuid : userMeta.getKeys(false)) {
			
			ConfigurationSection userProfile = userMeta.getConfigurationSection(uuid);
			
			final Long lastReset = userProfile.getLong("lastReset");
			final com.base.profile.Reputation reputation = new com.base.profile.Reputation(userProfile.getInt("reputation"));
			
			UserProfile profile = new UserProfile(UUID.fromString(uuid), lastReset, reputation);
			
			this.userMeta.add(profile);
		}
		
	}
	
	public boolean playerExists(Player player) {
		return !this.userMeta.stream().noneMatch(i -> i.uuid.compareTo(player.getUniqueId()) == 0);
	}
	public Response registerPlayer(Player player, int reputation) {
		
		if(playerExists(player)) {
			return new Response(false, "&cYou're already registered!");
		}
		
		
		try {
			UserProfile profile = new UserProfile(player.getUniqueId(), System.currentTimeMillis(), new com.base.profile.Reputation(reputation));
			boolean success = this.userMeta.add(profile);
			
			if(success){
				return new Response(success, "&aSuccessfully registered!");
			}else {
				return new Response(success, "&cError could not store user to local cashe!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return new Response(false, "&cAn unknown exception has accured");
		}
	}
	public void save() {
		ConfigurationSection userMeta = configuration.getConfigurationSection("Usermeta");
		for(UserProfile profile : this.userMeta) {
			ConfigurationSection uuid = userMeta.createSection(profile.uuid.toString());
			uuid.set("lastReset", profile.timer);
			uuid.set("reputation", profile.reputation.getReputation());
		}
		Reputation.getInstance().configManager.save();
	}
	
	
}
