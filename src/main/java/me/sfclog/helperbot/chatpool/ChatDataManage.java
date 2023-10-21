package me.sfclog.helperbot.chatpool;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class ChatDataManage {

    public static HashMap<Player, ChatData > data = new HashMap<Player, ChatData>();



    public static void load(Player p) {
        if(!data.containsKey(p)) {
            data.put(p,new ChatData(p));
        }
    }

    public static void remove(Player p) {
        if(data.containsKey(p)) {
            data.remove(p);
        }
    }

    public static ChatData getPlayer(Player p) {
        if(data.containsKey(p)) {
            return data.get(p);
        }
        return null;
    }
}
