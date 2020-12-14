package com.base.profile;

import java.util.UUID;

public class UserProfile {

	public UUID uuid;
	public Long timer;
	public Reputation reputation;
	
	public UserProfile(UUID uuid, Long timer, Reputation reputation) {
		this.uuid = uuid;
		this.timer = timer;
		this.reputation = reputation;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Long getTimer() {
		return timer;
	}

	public void setTimer(Long timer) {
		this.timer = timer;
	}

	public Reputation getReputation() {
		return reputation;
	}

	public void setReputation(Reputation reputation) {
		this.reputation = reputation;
	}
}
