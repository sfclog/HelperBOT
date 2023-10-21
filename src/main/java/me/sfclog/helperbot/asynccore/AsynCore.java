package me.sfclog.helperbot.asynccore;

import me.sfclog.helperbot.Main;
import me.sfclog.helperbot.chatpool.ChatData;
import me.sfclog.helperbot.chatpool.ChatPoolGlobal;
import me.sfclog.helperbot.chatpool.ChatPoolSync;
import org.bukkit.Bukkit;

public class AsynCore {

    public static void update() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Main.pl, new Runnable() {
            public void run() {
                ChatPoolSync.update();
                ChatPoolGlobal.update();
            }
        }, 1, 1);
    }
}
