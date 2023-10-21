package me.sfclog.helperbot.hook;

import me.sfclog.helperbot.chatpool.ChatPoolGlobal;
import me.sfclog.simpsyncchat.api.event.ChatDiscordEvent;
import me.sfclog.simpsyncchat.api.event.ChatPublicEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SimpSyncChatEvent implements Listener {

    @EventHandler
    public void onPublicChat(ChatPublicEvent e) {
        String msg = e.getMsg();
        if(msg != null) {
            String fix = ChatColor.stripColor(msg);
            if(fix != null && fix.toUpperCase().contains("@BOT")) {
                ChatPoolGlobal.send_chat_public(fix);
            }
        }
    }
    @EventHandler
    public void onDiscordChat(ChatDiscordEvent e) {
        String msg = e.getMsg();
        if(msg != null) {
            String fix = ChatColor.stripColor(msg);
            if(fix != null && fix.toUpperCase().contains("@BOT")) {
                ChatPoolGlobal.send_chat_public(fix);
            }
        }
    }
}
