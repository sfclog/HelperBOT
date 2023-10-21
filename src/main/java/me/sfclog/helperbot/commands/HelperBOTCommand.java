package me.sfclog.helperbot.commands;


import me.sfclog.helperbot.chatpool.ChatData;
import me.sfclog.helperbot.chatpool.ChatDataManage;
import me.sfclog.helperbot.config.PluginConfig;
import me.sfclog.helperbot.config.TrainerData;
import me.sfclog.helperbot.trainer.TrainerGPT;
import me.sfclog.helperbot.utils.Color;
import me.sfclog.helperbot.utils.Send;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class HelperBOTCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp() || p.hasPermission("*")) {
                if (args.length < 1) {
                    send(sender, " ");
                    send(sender, "&d&lHelperBOT &f| ChatBot GPT");
                    send(sender, "&fAuthor: &3SFC_Log (Coder/Trainer)");
                    send(sender, "&fVersion: &71.0-Beta");
                    send(sender, " ");
                    send(sender, " &f/helperbot <msg> &ađể hỏi các câu hỏi");
                    send(sender, " &f/helperbot reload &ađể tải lại plugin");
                    send(sender, " ");
                } else if(args[0].equalsIgnoreCase("reload")) {
                    PluginConfig.reload();
                    TrainerData.reload();
                    TrainerGPT.load_data();
                    send(sender,"&aĐã tải lại plugin!");
                } else {
                    String msg = "";
                    for (int i = 0; i < args.length; i++)
                        msg = String.valueOf(msg) + args[i] + " ";
                    if (msg != null && !msg.isEmpty()) {
                        ChatData data = ChatDataManage.getPlayer(p);
                        if (data != null) {
                            data.sender(msg);
                            p.sendMessage(Color.tran("&7 &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m"));
                            p.sendMessage(" ");
                            Send.send(p, " " + PluginConfig.getlang("Lang.Send").replace("<player_name>", p.getName()).replace("<msg>", msg), Sound.BLOCK_NOTE_BLOCK_BIT);
                            p.sendMessage(" ");
                            p.sendMessage(Color.tran("&7 &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m"));
                        }
                    }
                }
            } else {
                if (args.length < 1) {
                    send(sender, " ");
                    send(sender, "&d&lHelperBOT &f| ChatBot GPT");
                    send(sender, "&fAuthor: &3SFC_Log (Coder/Trainer)");
                    send(sender, "&fVersion: &71.0-Beta");
                    send(sender, " ");
                    send(sender, " &f/helperbot <msg> &ađể hỏi các câu hỏi");
                    send(sender, " ");
                } else {
                    String msg = "";
                    for (int i = 0; i < args.length; i++)
                        msg = String.valueOf(msg) + args[i] + " ";
                    if (msg != null && !msg.isEmpty()) {
                        ChatData data = ChatDataManage.getPlayer(p);
                        if (data != null) {
                            data.sender(msg);
                            Send.send(p, PluginConfig.getlang("Lang.Send").replace("<player_name>", p.getName()).replace("<msg>", msg), Sound.BLOCK_NOTE_BLOCK_BIT);
                        }
                    }
                }
            }
        } else {
            if (args.length < 1) {
                send(sender, " ");
                send(sender, "&d&lHelperBOT &f| ChatBot GPT");
                send(sender, "&fAuthor: &3SFC_Log (Coder/Trainer)");
                send(sender, "&fVersion: &71.0-Beta");
                send(sender, " ");
                send(sender, " &f/helperbot reload &ađể tải lại plugin");
                send(sender, " ");
            } else if(args[0].equalsIgnoreCase("reload")) {
                PluginConfig.reload();
                TrainerData.reload();
                TrainerGPT.load_data();
                send(sender, "&aĐã tải lại plugin!");
            }
        }
        return false;
    }

    public static void send(CommandSender s , String msg) {
        s.sendMessage(Color.tran(msg));
    }

}
