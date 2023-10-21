package me.sfclog.helperbot.chatpool;


import com.plexpt.chatgpt.entity.chat.Message;
import me.sfclog.helperbot.Main;
import me.sfclog.helperbot.utils.Color;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChatData {

    public Player p;
    public List<Message> sender;

    public ChatData(Player p) {
        this.p = p;
        this.sender = new ArrayList<>();
    }

    public void sender(String msg) {
        clear_cache();
        this.sender.add(Message.of(msg));
        ChatPoolSync.send_chat(this);

    }

    public void clear_cache() {
        int size = this.sender.size();
        if(size > Main.MAX_CACHE) {
            int remove = size - 1;
            sender.remove(remove);
        }
    }
    public List<Message> getListSend() {
        return this.sender;
    }
    public void reply(String msg) {
      if(this.p != null) {
          this.p.sendMessage(Color.tran("&7 &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m"));
          this.p.sendMessage(" ");
          this.p.sendMessage(ChatColor.WHITE + " " + msg);
          this.p.sendMessage(" ");
          this.p.sendMessage(Color.tran("&7 &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m &m"));
          this.p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,50,1);
      }
    }

    public Player getPlayer() {
        return this.p;
    }
}
