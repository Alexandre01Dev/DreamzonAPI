package alexandre01.dreamzon.bungeecord.bungee.listeners;


import alexandre01.dreamzonapi.spigot.utils.Message;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerSwitch implements Listener {

    @EventHandler
    public void switchServe(ServerSwitchEvent e){
        ProxiedPlayer player = e.getPlayer();

        player.sendMessage(new TextComponent(Message.prefix+"§aVous avez rejoint le serveur §b"+player.getServer().getInfo().getName()+" §a!"));

    }
}
