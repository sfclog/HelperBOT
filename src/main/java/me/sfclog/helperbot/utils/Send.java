package me.sfclog.helperbot.utils;

import me.sfclog.helperbot.config.PluginConfig;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Send {

    public static void send(Player p , String msg , Sound sound) {
        p.sendMessage(PluginConfig.getlang("Lang.Prefix") + msg);
        p.playSound(p.getLocation(),sound,100,1);
    }
}
