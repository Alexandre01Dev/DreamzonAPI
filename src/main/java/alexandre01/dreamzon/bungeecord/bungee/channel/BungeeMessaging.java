package alexandre01.dreamzon.bungeecord.bungee.channel;

import alexandre01.dreamzonapi.spigot.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import org.bukkit.entity.Player;

public class BungeeMessaging {

    public static void sendPlayerToServer(Player player, String server){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        out.writeUTF("Connect");
        out.writeUTF(server);

        player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());

    }
}
