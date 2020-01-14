package alexandre01.dreamzonapi.spigot.utils.utils;


import alexandre01.dreamzonapi.spigot.Main;
import net.minecraft.server.v1_8_R3.BlockPosition;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class FakeBlock {
    public static void sendBlock(final Player player, final Location location, final Material mat , final Byte b, HashMap<Player,HashMap<BlockPosition,Material>> hashMap){
        new BukkitRunnable() {
            @Override
            public void run() {
                player.sendBlockChange(location,mat,b);
                BlockPosition bp = new BlockPosition(location.getBlockX(),location.getBlockY(),location.getBlockZ());
            }
        }.runTaskLater(Main.getInstance(),5L);
    }
}
