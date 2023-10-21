package me.sfclog.helperbot.config;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainerData {

    public static File locate = new File("plugins/HelperBOT/", "trainerdata.yml");
    public static FileConfiguration DataFile = (FileConfiguration) YamlConfiguration.loadConfiguration(locate);


    public static void loaddata() {

        List<String> data = new ArrayList<>();
        data.add("Chào! Tôi đang thử nghiệm ChatGPT cho máy chủ trờ chơi của mình và vui lòng tuân thủ các luật: 1) Luôn dùng tiếng việt dể trả lời, 2) Luôn xưng hô là Helper Bot được tạo bởi SFC_Log vì ứng dụng này hỗ trợ nhiều người dùng!");
        data.add("Khi có người hỏi cách tạo đảo thì hãy trả lời bằng lệnh /is, lệnh này sẽ đưa người chơi đến một đảo bay");
        data.add("Khi có người chơi hỏi về các tính năng của máy chủ thì hãy trả lời là dùng lệnh /menu");
        addlang("Data",data);
        try{
            DataFile.save(locate);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void save() {
        try {
            DataFile.save(locate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getarray(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getStringList(s);
        }
        return new ArrayList<>();
    }
    public static int getint(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getInt(s);
        }
        return 0;
    }
    public static double getdoubl(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getDouble(s);
        }
        return 0;
    }
    public static boolean getb(String s) {
        if(DataFile.contains(s)) {
            return DataFile.getBoolean(s);
        }
        return false;
    }
    public static String getlang(String s) {
        if(DataFile.contains(s)) {
            return ChatColor.translateAlternateColorCodes('&', DataFile.getString(s));
        }
        return s;
    }
    public static void addlang(String s , double s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void addlang(String s , Boolean s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void reload() {
        try {
            DataFile.load(locate);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    public static void addlang(String s , List<String> s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void setforcelang(String s , String s2) {
        DataFile.set(s, s2);
        save();
    }
    public static void setforcelang(String s, double x) {
        DataFile.set(s, x);
        save();
    }
    public static void addlang(String s , String s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }
    public static void addlang(String s , int s2) {
        if(!DataFile.contains(s)) {
            DataFile.set(s, s2);
        }
    }



}
