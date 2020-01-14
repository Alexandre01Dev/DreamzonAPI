package alexandre01.dreamzonapi.spigot.utils;


import alexandre01.dreamzonapi.spigot.Main;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.UUID;

public class PlayerUtils {

    public static void playerKill(Player player){
        player.setHealth(0.0D);
    }

    public static void playerDamage(Player player, double damage){
        player.damage(damage);
    }

    public static void playerSetMaxHealth(Player player, double health){
        player.setMaxHealth(health);
    }

    public static void playerHeal(Player player){
        player.setMaxHealth(20.0D);
    }

    public static void playerHeal(Player player, double heal){
        int d = (int) player.getHealth();
        d += heal;
        player.setHealth(d);
    }

    public static void playerFeed(Player player){
        player.setFoodLevel(20);
    }

    public static void playerFeed(Player player, int feed){
        int d = player.getFoodLevel();
        d += feed;
        player.setFoodLevel(d);
    }

    public static UUID getUUID(Player player){
        return player.getUniqueId();
    }

    public static void playerSetGameMode(Player player, GameMode gameMode){
        player.setGameMode(gameMode);
    }

    public static void playerAddPotionEffect(Player player, PotionEffectType potionEffect, int time, int level){
        player.addPotionEffect(new PotionEffect(potionEffect, time*20, level));
    }

    public static void playerRemovePotionEffect(Player player, PotionEffectType potionEffect){
        player.removePotionEffect(potionEffect);
    }

    public static void playerRemoveAllPotionEffect(Player player){
        for(PotionEffect potion : player.getActivePotionEffects()){
            player.removePotionEffect(potion.getType());
        }
    }

    public static void playerKick(Player player, String raison){
        player.kickPlayer(raison);
    }

    public static void playerTeleport(Player player, Object obj){

        if((obj instanceof Player)){
            Player target = (Player) obj;
            player.teleport(target);

        }else if (obj instanceof Location){
            Location loc = (Location) obj;
            player.teleport(loc);

        }else if(obj instanceof Entity){
            Entity ent = (Entity) obj;
            player.teleport(ent);

        }else if (obj instanceof LivingEntity){
            LivingEntity lent = (LivingEntity) obj;
            player.teleport(lent);
        }
    }

    public static void playerBurn(Player player, int ticks){
        player.setFireTicks(ticks);
    }

    public static void playerBurnOff(Player player){
        player.setFireTicks(0);
    }

    public static void playerUnlockAchivement(Player player, Achievement achievement){
        player.awardAchievement(achievement);
    }

    public static Inventory playerGetInventory(Player player){
        return player.getInventory();
    }

    public static String playerGetInventoryName(Player player){
        return player.getInventory().getName();
    }

    public static String playerGetInventoryTitle(Player player){
       return player.getInventory().getTitle();
    }

    public boolean playerInventoryHasEmptySlot(Player player){
        ItemStack[] arrayOfItemStack;
        int j = (arrayOfItemStack = player.getInventory().getContents()).length;

        for(int i = 0; i < j; i++) {
            ItemStack items = arrayOfItemStack[i];
            if (items == null) {
                return Boolean.valueOf(false);
                }
             }
            return Boolean.valueOf(true);
        }

        public static void playerClearInventory(Player player){
            player.getInventory().clear();
        }

        public static Integer playerGetLevel(Player player){
            return Integer.valueOf(player.getLevel());
        }

        public static void playerSetVelocity(Player player, double x, double y, double z){
            player.setVelocity(new Vector(x,y,z));
        }

        public static Integer playerGetPing(Player player){
            CraftPlayer cp = (CraftPlayer) player;
            EntityPlayer ep = cp.getHandle();
            return Integer.valueOf(ep.ping);
        }

        public static void playerSendForceRespawn(Player player, int ticks){
            final String playername = player.getName();
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

                public void run() {

                    Player player = Bukkit.getPlayer(playername);

                    if(player == null || !player.isDead() || player.isOnline()){
                        PacketPlayInClientCommand packet = new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);

                        EntityPlayer ep = ((CraftPlayer) player).getHandle();
                        if(ep.playerConnection != null && !ep.playerConnection.isDisconnected()){
                            ep.playerConnection.a(packet);
                        }

                    }
                }
            }, (long) ticks);

        }

}
