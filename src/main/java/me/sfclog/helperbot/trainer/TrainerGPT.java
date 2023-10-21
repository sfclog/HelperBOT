package me.sfclog.helperbot.trainer;

import com.plexpt.chatgpt.entity.chat.Message;
import me.sfclog.helperbot.Main;
import me.sfclog.helperbot.chatpool.ChatGPT;
import me.sfclog.helperbot.config.TrainerData;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TrainerGPT {

    public static List<Message> train = new ArrayList<>();

    public static List<Message> getAll() {
        return train;
    }


    public static void load_data() {
        train.clear();
        int i = 0;
        for(String data : TrainerData.getarray("Data")) {
            if(data != null) {
                train.add(Message.of(data));
                i++;
            }
        }
        Main.sendlog("&8(&dHelperBOT&8) &fTải thành công &e" + i + " &fđoạn hội thoại huấn luyện vào ChatGPT");
    }

}
