package alexandre01.dreamzonapi.spigot.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TitleUtils {

        private TitleUtils(){ }

        public static void sendTitle(Player player , String title , String subtitle)
        {
            PacketPlayOutTitle Title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE ,
                    IChatBaseComponent.ChatSerializer.a("{\"text\":\" "+title+"\",\"color\":\"green\",\"bold\":true}") , 20 , 40 , 30) ;
            PacketPlayOutTitle SubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE ,
                    IChatBaseComponent.ChatSerializer.a("{\"text\":\" "+subtitle+"\",\"color\":\"green\",\"bold\":true}") , 20 , 40 , 30) ;
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(SubTitle);
            connection.sendPacket(Title);
        }
        public static void sendActionBar(Player player, String message) {
            PlayerConnection con = ((CraftPlayer) player).getHandle().playerConnection;
            IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
            PacketPlayOutChat packet = new PacketPlayOutChat(chat, (byte) 2);
            con.sendPacket(packet);
        }

}
