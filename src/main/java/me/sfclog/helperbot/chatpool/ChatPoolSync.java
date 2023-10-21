package me.sfclog.helperbot.chatpool;

import me.sfclog.helperbot.Main;
import me.sfclog.helperbot.utils.BungeeSendMSG;
import me.sfclog.helperbot.utils.PlayerUtils;
import me.sfclog.helperbot.utils.TextFix;
import org.bukkit.Bukkit;

import java.util.HashSet;

public class ChatPoolSync {

    public static HashSet<ChatData> data = new HashSet<>();


    public static void update() {
        data.removeIf(a -> chat(a));
    }

    private static boolean chat(ChatData a) {
        if(PlayerUtils.is_online(a.getPlayer())) {
            Bukkit.getScheduler().runTaskAsynchronously(Main.pl, new Runnable() {
                @Override
                public void run() {
                    String res = TextFix.fix(ChatGPT.send_msg(a.getListSend()));
                    if(res != null) {
                        a.reply(res);
                        Main.log.writelog(res);
                    }
                }
            });
        }
        return true;
    }

    public static void send_chat(ChatData chatData) {
        data.add(chatData);
    }
}
