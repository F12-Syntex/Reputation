package com.base.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public abstract class SubEvent implements Listener{

    public abstract String name();
    public abstract String bypass();
    public abstract String info();
    
    @EventHandler
    public abstract void Movement(PlayerMoveEvent e);
    
    @EventHandler
    public abstract void Attack(EntityDamageEvent e);
    
    @EventHandler
    public abstract void PlayerMessage(AsyncPlayerChatEvent e);

}
