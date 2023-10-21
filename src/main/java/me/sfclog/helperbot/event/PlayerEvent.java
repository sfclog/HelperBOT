package me.sfclog.helperbot.event;

import me.sfclog.helperbot.chatpool.ChatDataManage;
import me.sfclog.helperbot.chatpool.ChatPoolGlobal;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;;

public class PlayerEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(p != null) {
            ChatDataManage.load(p);
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if(p != null) {
            ChatDataManage.remove(p);
        }
    }
}
