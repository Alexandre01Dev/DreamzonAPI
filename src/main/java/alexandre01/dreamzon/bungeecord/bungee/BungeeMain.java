package alexandre01.dreamzon.bungeecord.bungee;

import alexandre01.dreamzon.bungeecord.bungee.listeners.ServerSwitch;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {

    private static BungeeMain instance;

    @Override
    public void onEnable() {
        instance = this;
        getProxy().getPluginManager().registerListener(this, new ServerSwitch());
    }

    public static BungeeMain getInstance() {
        return instance;
    }
}
