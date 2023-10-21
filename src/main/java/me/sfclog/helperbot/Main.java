package me.sfclog.helperbot;





import com.plexpt.chatgpt.ChatGPT;
import io.github.leonardosnt.bungeechannelapi.BungeeChannelApi;
import me.sfclog.helperbot.asynccore.AsynCore;
import me.sfclog.helperbot.chatpool.ChatDataManage;
import me.sfclog.helperbot.commands.HelperBOTCommand;
import me.sfclog.helperbot.config.PluginConfig;
import me.sfclog.helperbot.config.TrainerData;
import me.sfclog.helperbot.event.PlayerEvent;
import me.sfclog.helperbot.hook.SimpSyncChatEvent;
import me.sfclog.helperbot.log.Logger;
import me.sfclog.helperbot.trainer.TrainerGPT;
import me.sfclog.helperbot.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class Main extends JavaPlugin implements PluginMessageListener {

    public static ChatGPT chatGPT;
    public static Plugin pl;


    public static int MAX_CACHE;

    public static Logger log;

    public static BungeeChannelApi msg;

    public static boolean simpsyncchat;

    @Override
    public void onEnable() {
        pl = this;
        sendlog(" ");
        sendlog("&d&lHELPER BOT &f| Chat Bot GPT");
        sendlog("&fAuthor: &3SFC_Log (Coder/Trainer GPT)");
        sendlog(" ");
        sendlog("&aEnable plugin");
        sendlog(" ");
        PluginConfig.loadlang();
        TrainerData.loaddata();
        log = new Logger();
        msg = new BungeeChannelApi(this);
        MAX_CACHE = PluginConfig.getint("ChatGPT.MaxCache");
        simpsyncchat = PluginConfig.getb("ChatGPT.HookSimpSyncChat");



        // key api
        chatGPT = ChatGPT.builder()
                .apiKeyList(PluginConfig.getarray("ChatGPT.ApiKeys"))
                .timeout(1000)
                .apiHost("https://api.openai.com/") //反向代理地址
                .build()
                .init();
        getServer().getPluginManager().registerEvents(new PlayerEvent(),this);
        getServer().getPluginCommand("helperbot").setExecutor(new HelperBOTCommand());
        AsynCore.update();
        TrainerGPT.load_data();

        //simpsyncchat2
        if(simpsyncchat) {
            if(Bukkit.getPluginManager().getPlugin("SimpSyncChat2") == null) {
                simpsyncchat = false;
            } else {
                sendlog("&dHook SimpSyncChat2");
                getServer().getPluginManager().registerEvents(new SimpSyncChatEvent(),this);
                simpsyncchat = true;
            }
        }

        //reg bungee msg channel
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p != null) {
                ChatDataManage.load(p);
            }
        }

    }

    public static void sendlog(String msg) {
        Bukkit.getConsoleSender().sendMessage(Color.tran(msg));
    }

    @Override
    public void onDisable() {
        sendlog(" ");
        sendlog("&d&lHELPER BOT &f| Chat Bot GPT");
        sendlog("&fAuthor: &3SFC_Log (Coder/Trainer GPT)");
        sendlog(" ");
        sendlog("&cDisable plugin");
        sendlog(" ");
        pl = null;
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
    }
}
