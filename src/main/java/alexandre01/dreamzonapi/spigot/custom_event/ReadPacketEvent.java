package alexandre01.dreamzonapi.spigot.custom_event;

import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ReadPacketEvent extends Event implements Cancellable {
    private final Player player;
    private boolean isCancelled;
    private final Packet<?> packet;

    public ReadPacketEvent(Player player, Packet<?> packet) {
        this.player = player;
        this.packet = packet;

        this.isCancelled = false;
    }

    public Packet<?> getPacket() {
        return packet;
    }

    public Player getPlayer() {
        return player;
    }
    public String getPacketName(){
        return packet.getClass().getSimpleName();
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public String getPlayerName() {
        return this.player.getName();
    }



}
