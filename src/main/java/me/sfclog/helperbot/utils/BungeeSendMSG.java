package me.sfclog.helperbot.utils;

import me.sfclog.helperbot.Main;

public class BungeeSendMSG {


    public static void sendmsg(String msg) {

        Main.msg.getPlayerList("ALL")
                .whenComplete((result, error) -> {
                   result.stream().forEach(a -> Main.msg.sendMessage(a,msg));
            });
    }
}
