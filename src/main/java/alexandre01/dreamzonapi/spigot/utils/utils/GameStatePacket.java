package alexandre01.dreamzonapi.spigot.utils.utils;




import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class GameStatePacket {
    public static void send(Player player, int type, float state) {
        PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(type, state);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
