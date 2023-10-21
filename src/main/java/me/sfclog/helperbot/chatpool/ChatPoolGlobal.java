package me.sfclog.helperbot.chatpool;

import com.plexpt.chatgpt.entity.chat.Message;
import me.sfclog.helperbot.Main;
import me.sfclog.helperbot.utils.BungeeSendMSG;
import me.sfclog.helperbot.utils.Color;
import me.sfclog.helperbot.utils.TextFix;
import me.sfclog.simpsyncchat.api.SimpSyncChatAPI;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ChatPoolGlobal {

    public static HashSet<String> data_public = new HashSet<>();

    public static List<Message> cache_public = new ArrayList<>();

    public static void update() {
        data_public.removeIf(a -> chat_public());
    }

    private static boolean chat_public() {
            Bukkit.getScheduler().runTaskAsynchronously(Main.pl, new Runnable() {
                @Override
                public void run() {
                    String res = TextFix.fix(ChatGPT.send_msg(cache_public));
                    if(res != null) {
                        BungeeSendMSG.sendmsg(Color.tran("&7 &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m"));
                        BungeeSendMSG.sendmsg(" ");
                        BungeeSendMSG.sendmsg(" " + res);
                        BungeeSendMSG.sendmsg(" ");
                        BungeeSendMSG.sendmsg(Color.tran("&7 &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m"));
                    }
                    if(Main.simpsyncchat) {
                        SimpSyncChatAPI.send_custom_to_discord("HelperBOT","https://api.mineatar.io/head/ORIGINALS_CUTE",res);
                    }
                }
            });
        return true;
    }

    public static void send_chat_public(String m) {
        Message msg = Message.of(m);
        cache_public.add(msg);
        chat_public();
        //clear cache
        if(cache_public.size() > Main.MAX_CACHE) {
            Message mm = cache_public.get(cache_public.size() - 1);
            if(mm != null) {
                cache_public.remove(m);
            }
        }
    }
}
