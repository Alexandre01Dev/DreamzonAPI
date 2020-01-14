package alexandre01.dreamzon.bungeecord.bungee.utils;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

public class BungeePlayerUtils {

    public static void playerGetPing(ProxiedPlayer player){
        player.getPing();
    }

    public static void playerGetName(ProxiedPlayer player){
        player.getName();
    }

    public static void playerGetServerName(ProxiedPlayer player){
        player.getServer().getInfo().getName();
    }

    public static void playerGetDisplayName(ProxiedPlayer player){
        player.getDisplayName();
    }

    public static void playerKick(ProxiedPlayer player, String raison){
        player.disconnect(new TextComponent(raison));
    }

    public static void playerSendMessage(ProxiedPlayer player, String message){
        player.sendMessage(new TextComponent(message));
    }

    public static UUID playerGetUUID(ProxiedPlayer player){
        return player.getUniqueId();
    }

    public static String playerGetUUIDToString(ProxiedPlayer player){
        return player.getUniqueId().toString();
    }

    public void playerIsConnected(ProxiedPlayer player){
        player.isConnected();
    }

    public void playerHasPermission(ProxiedPlayer player, String permission){
        player.hasPermission(permission);
    }

    public static void playerConnect(ProxiedPlayer player, ServerInfo server){
        player.connect(server);
    }

}
