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

public class PluginConfig {

    public static File locate = new File("plugins/HelperBOT/", "config.yml");
    public static FileConfiguration DataFile = (FileConfiguration) YamlConfiguration.loadConfiguration(locate);


    public static void loadlang() {

        List<String> key = new ArrayList<>();
        key.add("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");
        key.add("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");
        addlang("ChatGPT.ApiKeys",key);
        addlang("ChatGPT.MaxCache",15);
        addlang("ChatGPT.HookSimpSyncChat",true);


        addlang("Lang.Prefix","&8(&dHelperBOT&8) &f");
        addlang("Lang.Send","&f<player_name> &7» &dBot&8: &f<msg>");

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
            List<String> ss = new ArrayList<String>();
            for(String ok : DataFile.getStringList(s)) {
                ss.add(ChatColor.translateAlternateColorCodes('&',ok));
            }
            return ss;
        }
        return null;
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
