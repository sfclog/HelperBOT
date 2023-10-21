package me.sfclog.helperbot.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtils {

    public static boolean is_online(Player p) {
        if(p != null) {
            return true;
        }
        if(Bukkit.getPlayer(p.getName()) != null) {
            return true;
        }
        return false;
    }
}
