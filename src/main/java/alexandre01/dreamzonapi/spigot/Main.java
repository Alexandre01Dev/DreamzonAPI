package alexandre01.dreamzonapi.spigot;


import alexandre01.dreamzonapi.spigot.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        System.out.println(Message.prefix+"l'API est lancé !");
    }

    public static Main getInstance() {
        return instance;
    }
}
