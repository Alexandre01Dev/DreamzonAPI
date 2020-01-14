package alexandre01.dreamzon.bungeecord.bungee.utils;

import alexandre01.dreamzon.bungeecord.bungee.BungeeMain;


import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;

public class BungeeServerUtils {

    public static void getServerPlayers(ServerInfo server){
        server.getPlayers().size();
    }

    public static void getProxyPlayers(){
        BungeeMain.getInstance().getProxy().getPlayers().size();
    }

    public static void getNumberOfServer(){
        BungeeMain.getInstance().getProxy().getServers().size();
    }

    public static void proxyBroadCastMessage(String message){
        BungeeMain.getInstance().getProxy().broadcast(new TextComponent(message));
    }

    public static void proxyGetVersion(){
        BungeeMain.getInstance().getProxy().getVersion();
    }

    public static void proxyShutDown(){
        BungeeMain.getInstance().getProxy().stop();
    }
}
