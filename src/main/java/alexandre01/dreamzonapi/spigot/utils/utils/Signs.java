package alexandre01.dreamzonapi.spigot.utils.utils;


import alexandre01.dreamzonapi.spigot.Main;
import alexandre01.dreamzonapi.spigot.nms.Reflection;
import alexandre01.dreamzonapi.spigot.nms.Reflections;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Signs extends Reflection {
    public static boolean openSign(final Player p, String line1, String line2, String line3, String line4){
        Block block = p.getWorld().getBlockAt(250,1,1600);
        p.getWorld().getBlockAt(250,1,1600).setType(Material.SIGN_POST);
        Sign sign = (Sign) p.getWorld().getBlockAt(250,1,1600).getState();
        sign.setLine(0,line1);
        sign.setLine(1,line2);
        sign.setLine(2,line3);
        sign.setLine(3,line4);
        sign.update();
        try {
        new BukkitRunnable() {
            @Override
            public void run() {
                PacketPlayOutOpenSignEditor packet = new PacketPlayOutOpenSignEditor();
                try {
                    setValue(packet,"a",new BlockPosition(250,1,1600));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                sendPacket(p, packet);

            }
        }.runTaskLater(Main.getInstance(),1L);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //p.getWorld().getBlockAt(p.getLocation().getBlockX(),p.getLocation().getBlockY(),p.getLocation().getBlockZ()).setType(block.getType());
        //p.getWorld().getBlockAt(p.getLocation().getBlockX(),p.getLocation().getBlockY(),p.getLocation().getBlockZ()).setData(block.getData());
        return false;
    }
    public static void changeLine(Player p , int line , String msg) throws NoSuchFieldException, IllegalAccessException {
        WorldServer nmsWorld = ((CraftWorld) p.getWorld()).getHandle();
            PacketPlayOutUpdateSign packet = new PacketPlayOutUpdateSign();
            setValue(packet,"a", nmsWorld);
            setValue(packet,"b",new BlockPosition(p.getLocation().getBlockX(),p.getLocation().getBlockY(),p.getLocation().getBlockZ()));
            IChatBaseComponent[] lines = new IChatBaseComponent[4];
        lines[0] = IChatBaseComponent.ChatSerializer.a(ChatColor.BOLD + "Hello");
            setValue(packet,"c",lines);
            sendPacket(p, packet);

    }
}